package com.beimin.eveapi.character.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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
		assertEquals("Incorrect amount of medals found.", 2, medals.size());
		CharacterMedal medal = medals.toArray(new CharacterMedal[0])[1];
		assertEquals("Wrong medalID", 40125, medal.getMedalID());
		assertEquals("Wrong medal title", "Christian Fundamentalist Award", medal.getTitle());
		assertEquals("Wrong medal description", "For relentlessly trying to spread the Good Message. Even within an internet spaceship game.", medal.getDescription());
		assertEquals("Wrong medal reason", "cuz hes awesome", medal.getReason());
		assertEquals("Wrong medal issuerID", 753005810L, medal.getIssuerID());
		assertDate(2009, 12, 23, 0, 32, 04, medal.getIssued());
		assertEquals("Wrong medal corporationID", 182784411L, medal.getCorporationID().longValue());
		assertTrue("Should be public", medal.isPublic());
	}

	@Test
	public void responseHasMedalsFromCurrentCorp() throws ApiException {
		MedalsParser parser = MedalsParser.getInstance();
		CharacterMedalsResponse response = parser.getResponse(auth);
		Set<CharacterMedal> medals = response.getAll();
		CharacterMedal medal = medals.iterator().next();
		assertEquals("Wrong medalID", 38208, medal.getMedalID());
		assertNull("Wrong medal title", medal.getTitle());
		assertNull("Wrong medal description", medal.getDescription());
		assertEquals("Wrong medal reason", "found the undock button", medal.getReason());
		assertEquals("Wrong medal issuerID", 718955203L, medal.getIssuerID());
		assertDate(2010, 02, 29, 2, 14, 33, medal.getIssued());
		assertNull("Wrong medal corporationID", medal.getCorporationID());
		assertFalse("Should be private", medal.isPublic());
	}
}