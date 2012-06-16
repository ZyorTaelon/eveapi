package com.beimin.eveapi.character.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;


import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.medals.Medal;
import com.beimin.eveapi.shared.medals.MedalsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MedalsParserTest extends FullAuthParserTest {
	public MedalsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.MEDALS);
	}

	@Test
	public void getResponse() throws ApiException {
		MedalsParser parser = MedalsParser.getInstance();
		MedalsResponse response = parser.getResponse(auth);
		assertNotNull(response);
		List<Medal> medals = response.getMedals();
		assertEquals("Incorrect amount of members found.", 1, medals.size());
		Medal medal = medals.iterator().next();
		assertEquals("Wrong member characterID", 40125, medal.getMedalID());
		assertEquals("Wrong member name", "Christian Fundamentalist Award", medal.getTitle());
		assertEquals("Wrong member name", "For relentlessly trying to spread the Good Message. Even within an internet spaceship game.", medal.getDescription());
		if (medal instanceof CharacterMedal) {
			CharacterMedal charMedal = (CharacterMedal) medal;
			assertEquals("Wrong member name", "cuz hes awesome", charMedal.getReason());
			assertEquals("Wrong member name", 753005810L, charMedal.getIssuerID());
			assertDate(2009, 12, 23, 0, 32, 04, charMedal.getIssued());
			assertEquals("Wrong member name", 182784411L, charMedal.getCorporationID());
			assertTrue("Should be public", charMedal.isPublic());
		} else {
			fail("wrong medal type.");
		}
	}
}