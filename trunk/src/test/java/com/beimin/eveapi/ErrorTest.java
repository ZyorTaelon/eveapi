package com.beimin.eveapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.betterbe.eveapi.ApiError;
import com.betterbe.eveapi.assets.Parser;
import com.betterbe.eveapi.assets.Response;

public class ErrorTest {
	@Test
	public void testAssetsParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ErrorTest.class.getResourceAsStream("/ApiError115.xml");
		Response response = parser.getAssets(input);
		assertNotNull("Should have returned a result.", response);
		assertTrue("The error should have been set.", response.hasError());
		ApiError error = response.getError();
		assertEquals("Should have been code 115", 115, error.getCode());
		assertEquals("Assets already downloaded: retry after 2008-02-10 01:29:34.", error.getError());
	}
}