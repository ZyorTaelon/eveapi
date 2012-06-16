package com.beimin.eveapi.character.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MedalsParserTest extends FullAuthParserTest {
	public MedalsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.MEDALS);
	}

	@Test
	public void getResponse() throws ApiException {
		MedalsParser parser = MedalsParser.getInstance();
		CharacterMedalsResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<CharacterMedal> medals = response.getAll();
		assertEquals("Incorrect amount of medals found.", 1, medals.size());
		CharacterMedal medal = medals.iterator().next();
		assertEquals("Wrong medal characterID", 40125, medal.getMedalID());
		assertEquals("Wrong medal title", "Christian Fundamentalist Award", medal.getTitle());
		assertEquals("Wrong medal description", "For relentlessly trying to spread the Good Message. Even within an internet spaceship game.", medal.getDescription());
		assertEquals("Wrong medal reason", "cuz hes awesome", medal.getReason());
		assertEquals("Wrong medal issuerID", 753005810L, medal.getIssuerID());
		assertDate(2009, 12, 23, 0, 32, 04, medal.getIssued());
		assertEquals("Wrong medal corporationID", 182784411L, medal.getCorporationID());
		assertTrue("Should be public", medal.isPublic());
	}
}