/** Project Trade.*/

package com.db.tradestore.repository;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test class for TradeRepository.
 * 
 * @author kalpana.gagare
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TradeRepositoryTest {

	/** Autowired Instance of TradesRepository. */
	@Autowired
	private TradesRepository tradesRepository;

	/** Test case to test getTrades method. */
	@Test
	public void testGetTrades() {
		try {
			assertEquals(4, tradesRepository.getTrades().size());
		} catch (ParseException e) {

		}
	}
}
