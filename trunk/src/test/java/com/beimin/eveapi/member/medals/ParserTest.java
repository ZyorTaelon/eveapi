package com.beimin.eveapi.member.medals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.corporation.member.medals.MemberMedal;
import com.beimin.eveapi.corporation.member.medals.MemberMedalsParser;
import com.beimin.eveapi.corporation.member.medals.MemberMedalsResponse;

public class ParserTest {

	@Test
	public void testMemberTrackingParser() throws IOException, SAXException {
		MemberMedalsParser parser = MemberMedalsParser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/MemberMedals.xml");
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
		assertEquals("2008-11-12 07:39:28", memberMedal.getIssued());
	}
}