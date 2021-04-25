/** Project Trade.*/

package com.db.tradestore.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.db.tradestore.constant.TradeConstant;
import com.db.tradestore.model.Trade;

/**
 * Repository class for Trade.
 * 
 * @author kalpana.gagare
 *
 */
@Repository
public class TradesRepository {

	/**
	 * Method to return trades list.
	 * 
	 * @throws ParseException
	 */
	public List<Trade> getTrades() throws ParseException {
		List<Trade> tradeList = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat(TradeConstant.TRADE_DATE_FORMAT);
		Trade t1 = new Trade();
		t1.setId(1);
		t1.setTradeId("T1");
		t1.setVersion(1);
		t1.setCounterPartyId("CP-1");
		t1.setBookId("B1");
		t1.setMaturityDate(sdf.parse("20/05/2020"));
		t1.setCreatedDate(sdf.parse("25/04/2021"));
		t1.setExpired(false);

		Trade t2 = new Trade();
		t2.setId(2);
		t2.setTradeId("T2");
		t2.setVersion(2);
		t2.setCounterPartyId("CP-2");
		t2.setBookId("B1");
		t2.setMaturityDate(sdf.parse("20/05/2021"));
		t2.setCreatedDate(sdf.parse("25/04/2021"));
		t2.setExpired(false);

		Trade t3 = new Trade();
		t3.setId(3);
		t3.setTradeId("T2");
		t3.setVersion(1);
		t3.setCounterPartyId("CP-1");
		t3.setBookId("B1");
		t3.setMaturityDate(sdf.parse("20/05/2021"));
		t3.setCreatedDate(sdf.parse("14/03/2015"));
		t3.setExpired(false);

		Trade t4 = new Trade();
		t4.setId(4);
		t4.setTradeId("T3");
		t4.setVersion(3);
		t4.setCounterPartyId("CP-3");
		t4.setBookId("B2");
		t4.setMaturityDate(sdf.parse("20/05/2014"));
		t4.setCreatedDate(sdf.parse("25/04/2021"));
		t4.setExpired(true);

		tradeList.add(t1);
		tradeList.add(t2);
		tradeList.add(t3);
		tradeList.add(t4);
		return tradeList;
	}
}
