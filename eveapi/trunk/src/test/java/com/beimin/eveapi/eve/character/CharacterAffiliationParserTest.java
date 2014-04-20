package com.beimin.eveapi.eve.character;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class CharacterAffiliationParserTest extends NoAuthParserTest {
	public CharacterAffiliationParserTest() {
		super(ApiPath.EVE, ApiPage.CHARACTER_AFFILIATION);
	}

	@Test
	public void getResponse() throws ApiException {
		CharacterAffiliationParser parser = new CharacterAffiliationParser();
		CharacterAffiliationResponse response = parser.getResponse(1234567890L);
		Collection<CharacterAffiliation> chars = response.getAll();
		assertEquals(1, chars.size());
		CharacterAffiliation regner = chars.iterator().next();
		assertEquals("Regner", regner.getCharacterName());
		assertEquals(1234567890L, regner.getCharacterID());
		assertEquals("Federal Navy Academy", regner.getCorporationName());
		assertEquals(1000168L, regner.getCorporationID());
		assertEquals("CCP Devs", regner.getAllianceName());
		assertEquals(1337L, regner.getAllianceID().longValue());
		assertEquals("None", regner.getFactionName());
		assertEquals(1L, regner.getFactionID().longValue());
	}

	@Override
	public void extraAsserts(Map<String, String> req) {
		super.extraAsserts(req);
		assertEquals("1234567890", req.get("ids"));
	}
}