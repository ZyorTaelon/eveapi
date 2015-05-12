package com.beimin.eveapi.corporation.shareholders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.corporation.Shareholder;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.ShareholdersParser;
import com.beimin.eveapi.response.corporation.ShareholdersResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ShareholdersParserTest extends FullAuthParserTest {
	public ShareholdersParserTest() {
		super(ApiPath.CORPORATION, ApiPage.SHAREHOLDERS);
	}

	@Test
	public void getResponse() throws ApiException {
		ShareholdersParser parser = new ShareholdersParser();
		ShareholdersResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Collection<Shareholder> characters = response.getCharacters();
		assertEquals(1, characters.size());
		Shareholder characterShareholder = characters.iterator().next();
		assertEquals(126891489L, characterShareholder.getShareholderID());
		assertEquals("Dragonaire", characterShareholder.getShareholderName());
		assertEquals(632257314L, characterShareholder.getShareholderCorporationID().longValue());
		assertEquals("Corax.", characterShareholder.getShareholderCorporationName());
		assertEquals(1, characterShareholder.getShares());

		Collection<Shareholder> corporations = response.getCorporations();
		assertEquals(1, corporations.size());
		Shareholder corporationShareholder = corporations.iterator().next();
		assertEquals(632257314L, corporationShareholder.getShareholderID());
		assertEquals("Corax.", corporationShareholder.getShareholderName());
		assertEquals(1, corporationShareholder.getShares());
	}
}