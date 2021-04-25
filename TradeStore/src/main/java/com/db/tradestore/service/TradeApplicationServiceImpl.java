/** Project Trade.*/

package com.db.tradestore.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.db.tradestore.constant.TradeConstant;
import com.db.tradestore.exception.TradeNotSupportedException;
import com.db.tradestore.model.Trade;
import com.db.tradestore.repository.TradesRepository;

/**
 * Implementaion of TradeApplicationsService interface.
 * 
 * @author kalpana.gagare
 *
 */
@Service
public class TradeApplicationServiceImpl implements TradeApplicationService {

	/** Autowired instance of TradesRepository. */
	@Autowired
	private TradesRepository tradesRepository;

	@Override
	public List<Trade> validateAndInsertTrade(Trade trade) throws ParseException, TradeNotSupportedException {
		List<Trade> tradeList = tradesRepository.getTrades();
		if (Objects.nonNull(trade)) {
			SimpleDateFormat sdf = new SimpleDateFormat(TradeConstant.TRADE_DATE_FORMAT);
			Date date = new Date();
			Date currDate = sdf.parse(sdf.format(date));
			if (trade.getMaturityDate().before(currDate)) {
				throw new TradeNotSupportedException("Maturity date should be greater than Today's date.");
			}

			List<Trade> minVersionTradeList = tradeList.stream().filter(t -> t.getVersion() > trade.getVersion())
					.collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(minVersionTradeList)) {
				throw new TradeNotSupportedException("Invalid version of Trade.");
			} else {
				List<Trade> sameVersionTradeList = tradeList.stream().filter(t -> t.getVersion() == trade.getVersion())
						.collect(Collectors.toList());
				if (CollectionUtils.isEmpty(sameVersionTradeList)) {
					tradeList.add(trade);
				} else {
					sameVersionTradeList.forEach(t -> {
						t.setTradeId(trade.getTradeId());
						t.setBookId(trade.getBookId());
						t.setCounterPartyId(trade.getCounterPartyId());
						t.setCreatedDate(trade.getCreatedDate());
						t.setMaturityDate(trade.getMaturityDate());
						t.setExpired(trade.isExpired());
					}

					);
				}
			}
		}
		return tradeList;
	}

}
