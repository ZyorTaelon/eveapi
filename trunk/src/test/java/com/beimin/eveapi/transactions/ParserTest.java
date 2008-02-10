package com.beimin.eveapi.transactions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.betterbe.eveapi.transactions.Response;
import com.betterbe.eveapi.transactions.Parser;

public class ParserTest {

	@Test
	public void testIndustryParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/ApiError115.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		assertTrue("Todo: ", true);
	}
}