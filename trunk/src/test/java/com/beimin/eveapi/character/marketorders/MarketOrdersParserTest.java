package com.beimin.eveapi.character.marketorders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.TimeZone;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.marketorders.AbstractMarketOrdersParser;
import com.beimin.eveapi.shared.marketorders.ApiMarketOrder;
import com.beimin.eveapi.shared.marketorders.MarketOrdersResponse;

public class MarketOrdersParserTest {

	@Test
	public void marketOrderParser() throws IOException, SAXException,
			ParseException {
		AbstractMarketOrdersParser parser = MarketOrdersParser.getInstance();
		InputStream input = MarketOrdersParserTest.class
				.getResourceAsStream("/character/MarketOrders.xml");
		MarketOrdersResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiMarketOrder> orders = response.getMarketOrders();
		assertEquals(9, orders.size());
		boolean found = false;
		for (ApiMarketOrder order : orders) {
			if (order.getOrderID() == 5630641) {
				found = true;
				assertEquals(150208955, order.getCharID());
				assertEquals(60010783, order.getStationID());
				assertEquals(2891, order.getVolEntered());
				assertEquals(2889, order.getVolRemaining());
				assertEquals(1, order.getMinVolume());
				assertEquals(0, order.getOrderState());
				assertEquals(27351, order.getTypeID());
				assertEquals(32767, order.getRange());
				assertEquals(1000, order.getAccountKey());
				assertEquals(90, order.getDuration());
				assertEquals(0.00, order.getEscrow(), 0.0001);
				assertEquals(325.00, order.getPrice(), 0.0001);
				assertEquals(0, order.getBid());
				Calendar calendar = Calendar.getInstance(TimeZone
						.getTimeZone("GMT"));
				calendar.set(Calendar.YEAR, 2007);
				calendar.set(Calendar.MONTH, 11);
				calendar.set(Calendar.DAY_OF_MONTH, 2);
				calendar.set(Calendar.HOUR_OF_DAY, 12);
				calendar.set(Calendar.MINUTE, 18);
				calendar.set(Calendar.SECOND, 18);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(), order.getIssuedDate());
			}
		}
		assertTrue("test order wasn't found.", found);
	}
}