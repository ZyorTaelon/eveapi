package com.beimin.eveapi.corporation.member.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MedalsParserTest extends FullAuthParserTest {
	public MedalsParserTest() {
		super(ApiPath.CORPORATION, ApiPage.MEMBER_MEDALS);
	}

	@Test
	public void getResponse() throws ApiException {
		MemberMedalsParser parser = new MemberMedalsParser();
		MemberMedalsResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<MemberMedal> memberMedals = response.getAll();
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