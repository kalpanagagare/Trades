/** Project Trade.*/

package com.db.tradestore.service;

import java.text.ParseException;
import java.util.List;

import com.db.tradestore.exception.TradeNotSupportedException;
import com.db.tradestore.model.Trade;

/**
 * Interface for Trades Management.
 * 
 * @author kalpana.gagare
 *
 */
public interface TradeApplicationService {

	/**
	 * Method to validate and insert Trade.
	 * 
	 * @param trade
	 *            trade
	 * @return List<Trade> list of trades
	 * @throws ParseException
	 *             ParseException
	 * @throws TradeNotSupportedException
	 *             TradeNotSupportedException
	 */
	public List<Trade> validateAndInsertTrade(Trade trade) throws ParseException, TradeNotSupportedException;
}
