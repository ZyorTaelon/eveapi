package com.beimin.eveapi.account.apikeyinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.model.account.ApiKeyInfo;
import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.account.ApiKeyInfoParser;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;


public class ApiKeyInfoParserTest extends FullAuthParserTest {
	public ApiKeyInfoParserTest() {
		super(ApiPath.ACCOUNT, ApiPage.API_KEY_INFO);
	}

	@Test
	public void getResponse() throws Exception {
		ApiKeyInfoParser apiKeyInfoParser = new ApiKeyInfoParser();
		ApiKeyInfoResponse response = apiKeyInfoParser.getResponse(auth);
		assertNotNull(response);
		ApiKeyInfo apiKeyInfo = response.getApiKeyInfo();
		assertNotNull(apiKeyInfo);

		assertEquals(4227, apiKeyInfo.getAccessMask());
		assertNull(apiKeyInfo.getExpires());

		assertEquals(3, apiKeyInfo.getEveCharacters().size());

		List<Character> characters = new ArrayList<Character>(apiKeyInfo.getEveCharacters());

		assertEquals(987623974, characters.get(0).getCharacterID());
		assertEquals("Golden Gnu", characters.get(0).getName());
		assertEquals(1020386980, characters.get(0).getCorporationID());
		assertEquals("The Golden Gnu Corp", characters.get(0).getCorporationName());

		assertEquals(1652509239, characters.get(1).getCharacterID());
		assertEquals("GoldenGnu", characters.get(1).getName());
		assertEquals(1020386980, characters.get(1).getCorporationID());
		assertEquals("The Golden Gnu Corp", characters.get(1).getCorporationName());

		assertEquals(1683690353, characters.get(2).getCharacterID());
		assertEquals("Silver Gnu", characters.get(2).getName());
		assertEquals(1020386980, characters.get(2).getCorporationID());
		assertEquals("The Golden Gnu Corp", characters.get(2).getCorporationName());
		//assertEquals(5603, response.getCharacterID());
		//assertEquals(504903, response.getLogonMinutes());
	}
}