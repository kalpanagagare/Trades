/** Project Trade.*/

package com.db.tradestore.exception;

/**
 * @author kalpana.gagare
 *
 */
public class TradeNotSupportedException extends Exception {

	/** serial Version Id. */
	private static final long serialVersionUID = -8860834459482210361L;

	/**
	 * Constructor with error message.
	 * 
	 * @param errorMessage
	 *            errorMessage
	 */
	public TradeNotSupportedException(String errorMessage) {
		super(errorMessage);
	}

}
