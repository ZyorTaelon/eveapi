package com.beimin.eveapi.medals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.medals.CharacterMedal;
import com.beimin.eveapi.shared.medals.CorpMedal;
import com.beimin.eveapi.shared.medals.Medal;
import com.beimin.eveapi.shared.medals.MedalsParser;
import com.beimin.eveapi.shared.medals.MedalsResponse;

public class ParserTest {

	@Test
	public void testMedalParserCorp() throws IOException, SAXException {
		MedalsParser parser = MedalsParser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/CorpMedals.xml");
		MedalsResponse response = parser.getResponse(input);
		assertNotNull(response);
		List<Medal> medals = response.getMedals();
		assertEquals("Incorrect amount of members found.", 18, medals.size());
		Medal medal = medals.iterator().next();
		assertEquals("Wrong member characterID", 1745, medal.getMedalID());
		assertEquals("Wrong member name", "Capital Red Eyed Award", medal.getTitle());
		assertEquals("Wrong member name", "This award is given to captial pilots that not only fought on the front lines but stayed up way to late and past their 9pm bedtimes to kill the scum that think they are better than us.", medal.getDescription());
		if (medal instanceof CorpMedal) {
			CorpMedal corpMedal = (CorpMedal) medal;
			assertEquals("Wrong member name", 817217271L, corpMedal.getCreatorID());
			assertEquals("Wrong member name", "2008-11-12 07:37:00", corpMedal.getCreated());
		} else {
			fail("wrong medal type.");
		}
	}
	
	@Test
	public void testMedalParserCharacter() throws IOException, SAXException {
		MedalsParser parser = MedalsParser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/CharMedals.xml");
		MedalsResponse response = parser.getResponse(input);
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
			assertEquals("Wrong member name", "2009-12-23 00:32:04", charMedal.getIssued());
			assertEquals("Wrong member name", 182784411L, charMedal.getCorporationID());
			assertTrue("Should be public", charMedal.isPublic());
		} else {
			fail("wrong medal type.");
		}
	}
}