/** Project Trade.*/

package com.db.tradestore.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.db.tradestore.constant.TradeConstant;
import com.db.tradestore.exception.TradeNotSupportedException;
import com.db.tradestore.model.Trade;

/**
 * Test class for TradeApplicationServiceImpl.
 * 
 * @author kalpana.gagare
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TradeApplicationServiceImplTest {

	/** Autowired instance of TradeApplicationServiceImpl. */
	@Autowired
	private TradeApplicationServiceImpl tradeApplicationServiceImpl;

	/** Test method to test Invalid Version. */
	@Test
	public void testValidateAndInsertTradeInvalidVersion() {
		SimpleDateFormat sdf = new SimpleDateFormat(TradeConstant.TRADE_DATE_FORMAT);
		Date date = new Date();
		try {
			Date currDate = sdf.parse(sdf.format(date));

			Trade t1 = new Trade();
			t1.setTradeId("T1");
			t1.setVersion(0);
			t1.setCounterPartyId("CP-1");
			t1.setBookId("B1");
			t1.setMaturityDate(currDate);
			t1.setCreatedDate(sdf.parse("25/04/2021"));
			t1.setExpired(false);
			String msg = null;
			try {
				tradeApplicationServiceImpl.validateAndInsertTrade(t1);
			} catch (TradeNotSupportedException e) {
				msg = e.getMessage();
			}
			assertEquals(msg, "Invalid version of Trade.");
		} catch (ParseException p) {

		}
	}

	/** Test case to test Invalid Maturity Date. */
	@Test
	public void testValidateAndInsertTradeInvalidMaturityDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(TradeConstant.TRADE_DATE_FORMAT);
		try {
			Trade t1 = new Trade();
			t1.setTradeId("T1");
			t1.setVersion(1);
			t1.setCounterPartyId("CP-1");
			t1.setBookId("B1");
			t1.setMaturityDate(sdf.parse("25/03/2021"));
			t1.setCreatedDate(sdf.parse("25/04/2021"));
			t1.setExpired(false);
			String msg = null;
			try {
				tradeApplicationServiceImpl.validateAndInsertTrade(t1);
			} catch (TradeNotSupportedException e) {
				msg = e.getMessage();
			}
			assertEquals(msg, "Maturity date should be greater than Today's date.");
		} catch (ParseException p) {

		}

	}

	/** Test case to test Update Existing trade. */
	@Test
	public void testValidateAndInsertTradeUpdateTrade() {
		SimpleDateFormat sdf = new SimpleDateFormat(TradeConstant.TRADE_DATE_FORMAT);
		Date date = new Date();
		try {
			Date currDate = sdf.parse(sdf.format(date));

			Trade t1 = new Trade();
			t1.setTradeId("T4");
			t1.setVersion(3);
			t1.setCounterPartyId("CP-4");
			t1.setBookId("B4");
			t1.setMaturityDate(currDate);
			t1.setCreatedDate(sdf.parse("25/04/2021"));
			t1.setExpired(true);
			String msg = null;
			try {
				List<Trade> tradeList = tradeApplicationServiceImpl.validateAndInsertTrade(t1);
				Trade trade = tradeList.stream().filter(t -> t.getVersion() == t1.getVersion()).findFirst()
						.orElse(null);

				assertEquals("T4", trade.getTradeId());
				assertEquals("CP-4", trade.getCounterPartyId());
				assertEquals("B4", trade.getBookId());
				assertEquals(true, trade.isExpired());

			} catch (TradeNotSupportedException e) {
				msg = e.getMessage();
			}
			assertEquals(msg, null);
		} catch (ParseException p) {

		}

	}

	/** Test case to test Insert trade. */
	@Test
	public void testValidateAndInsertTradeInsertTrade() {
		SimpleDateFormat sdf = new SimpleDateFormat(TradeConstant.TRADE_DATE_FORMAT);
		Date date = new Date();
		try {
			Date currDate = sdf.parse(sdf.format(date));

			Trade t1 = new Trade();
			t1.setId(5);
			t1.setTradeId("T4");
			t1.setVersion(4);
			t1.setCounterPartyId("CP-4");
			t1.setBookId("B4");
			t1.setMaturityDate(currDate);
			t1.setCreatedDate(sdf.parse("25/04/2021"));
			t1.setExpired(true);
			String msg = null;
			try {
				List<Trade> tradeList = tradeApplicationServiceImpl.validateAndInsertTrade(t1);
				assertEquals(5, tradeList.size());

			} catch (TradeNotSupportedException e) {
				msg = e.getMessage();
			}
			assertEquals(msg, null);
		} catch (ParseException p) {

		}

	}

}
