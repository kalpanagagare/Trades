/** Project Trade.*/

package com.db.tradestore.model;

import java.util.Date;

/**
 * @author SkyWorld Computer
 *
 */
public class Trade {

	/** Id */
	private int id;

	/** The Trade Id. */
	private String tradeId;

	/** The Version. */
	private int version;

	/** The Counter Party Id. */
	private String counterPartyId;

	/** The Book Id. */
	private String bookId;

	/** The Maturity Date. */
	private Date maturityDate;

	/** The Creation Date. */
	private Date createdDate;

	/** The Expiry Status. */
	private boolean isExpired;

	/**
	 * Return id
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Return tradeId
	 * 
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}

	/**
	 * Sets tradeId.
	 * 
	 * @param tradeId
	 *            the tradeId to set
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	/**
	 * Return version
	 * 
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Sets version.
	 * 
	 * @param version
	 *            the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Return counterPartId
	 * 
	 * @return the counterPartyId
	 */
	public String getCounterPartyId() {
		return counterPartyId;
	}

	/**
	 * Sets counterPartyId.
	 * 
	 * @param counterPartyId
	 *            the counterPartyId to set
	 */
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	/**
	 * Return bookId
	 * 
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * Sets bookId.
	 * 
	 * @param bookId
	 *            the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * Return maturityDate
	 * 
	 * @return the maturityDate
	 */
	public Date getMaturityDate() {
		return maturityDate;
	}

	/**
	 * Sets maturityDate.
	 * 
	 * @param maturityDate
	 *            the maturityDate to set
	 */
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	/**
	 * Return createdDate
	 * 
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets createdDate.
	 * 
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Return isExpired
	 * 
	 * @return the isExpired
	 */
	public boolean isExpired() {
		return isExpired;
	}

	/**
	 * Sets isExpired.
	 * 
	 * @param isExpired
	 *            the isExpired to set
	 */
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

}
