package com.beimin.eveapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.character.assetlist.AssetListParser;
import com.beimin.eveapi.shared.assetlist.AbstractAssetListParser;
import com.beimin.eveapi.shared.assetlist.AssetListResponse;

public class ErrorTest {
	@Test
	public void testAssetsParser() throws IOException, SAXException {
		AbstractAssetListParser parser = AssetListParser.getInstance();
		InputStream input = ErrorTest.class.getResourceAsStream("/ApiError115.xml");
		AssetListResponse response = parser.getResponse(input);
		assertNotNull("Should have returned a result.", response);
		assertTrue("The error should have been set.", response.hasError());
		ApiError error = response.getError();
		assertEquals("Should have been code 115", 115, error.getCode());
		assertEquals("Assets already downloaded: retry after 2008-02-10 01:29:34.", error.getError());
	}
}