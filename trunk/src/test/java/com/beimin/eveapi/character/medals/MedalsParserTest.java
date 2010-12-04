package com.beimin.eveapi.character.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.FullApiParserTest;
import com.beimin.eveapi.shared.medals.Medal;
import com.beimin.eveapi.shared.medals.MedalsResponse;

public class MedalsParserTest extends FullApiParserTest {
	public MedalsParserTest() {
		super("/char/Medals.xml.aspx", "/character/Medals.xml");
	}

	@Test
	public void testMedalParserCharacter() throws IOException, SAXException {
		MedalsParser parser = MedalsParser.getInstance();
		MedalsResponse response = parser.getMedalsResponse(auth);
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