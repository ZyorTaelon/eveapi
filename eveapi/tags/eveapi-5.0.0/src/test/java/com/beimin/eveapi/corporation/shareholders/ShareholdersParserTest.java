package com.beimin.eveapi.corporation.shareholders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Test;


import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ShareholdersParserTest extends FullAuthParserTest {
	public ShareholdersParserTest() {
		super(ApiPath.CORPORATION, ApiPage.SHAREHOLDERS);
	}

	@Test
	public void getResponse() throws ApiException {
		ShareholdersParser parser = ShareholdersParser.getInstance();
		ShareholdersResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Collection<ApiShareholder> characters = response.getCharacters();
		assertEquals(1, characters.size());
		ApiShareholder characterShareholder = characters.iterator().next();
		assertEquals(126891489L, characterShareholder.getShareholderID());
		assertEquals("Dragonaire", characterShareholder.getShareholderName());
		assertEquals(632257314L, characterShareholder.getShareholderCorporationID().longValue());
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