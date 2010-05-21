package com.beimin.eveapi.corporation.shareholders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ShareholdersParserTest {

	@Test
	public void shareholdersParser() throws IOException, SAXException, ParseException {
		ShareholdersParser parser = ShareholdersParser.getInstance();
		InputStream input = ShareholdersParserTest.class.getResourceAsStream("/corporation/Shareholders.xml");
		ShareholdersResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiShareholder> characters = response.getCharacters();
		assertEquals(1, characters.size());
		ApiShareholder characterShareholder = characters.iterator().next();
		assertEquals(126891489L, characterShareholder.getShareholderID());
		assertEquals("Dragonaire", characterShareholder.getShareholderName());
		assertEquals(632257314L, characterShareholder.getShareholderCorporationID());
		assertEquals("Corax.", characterShareholder.getShareholderCorporationName());
		assertEquals(1, characterShareholder.getShares());

		Collection<ApiShareholder> corporations = response.getCorporations();
		assertEquals(1, corporations.size());
		ApiShareholder corporationShareholder = corporations.iterator().next();
		assertEquals(632257314L, corporationShareholder.getShareholderID());
		assertEquals("Corax.", corporationShareholder.getShareholderName());
		assertEquals(1, corporationShareholder.getShares());
	}
}