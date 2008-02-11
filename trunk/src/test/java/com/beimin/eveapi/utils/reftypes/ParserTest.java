package com.beimin.eveapi.utils.reftypes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {

	@Test
	public void testIndustryParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/RefTypes.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		assertTrue("Todo: ", true);
	}
}