package com.beimin.eveapi.order;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.order.Parser;
import com.beimin.eveapi.order.Response;

public class ParserTest {

	@Test
	public void testIndustryParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/MarketOrders.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		assertTrue("Todo: ", true);
	}
}