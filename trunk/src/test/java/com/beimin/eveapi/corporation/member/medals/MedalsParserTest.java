package com.beimin.eveapi.corporation.member.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

public class MedalsParserTest {

	@Test
	public void memberMedalsParser() throws IOException, SAXException {
		MemberMedalsParser parser = MemberMedalsParser.getInstance();
		InputStream input = MedalsParserTest.class.getResourceAsStream("/corporation/MemberMedals.xml");
		MemberMedalsResponse response = parser.getResponse(input);
		assertNotNull(response);
		List<MemberMedal> memberMedals = response.getMemberMedals();
		assertNotNull(memberMedals);
		assertEquals(45, memberMedals.size());
		MemberMedal memberMedal = memberMedals.iterator().next();
		assertEquals(1745, memberMedal.getMedalID());
		assertEquals(264288979L, memberMedal.getCharacterID());
		assertEquals("Ooy late night op", memberMedal.getReason());
		assertTrue("Should have been public", memberMedal.isPublic());
		assertEquals(817217271L, memberMedal.getIssuerID());
		assertDate(2008, 11, 12, 7, 39, 28, memberMedal.getIssued());
	}
}