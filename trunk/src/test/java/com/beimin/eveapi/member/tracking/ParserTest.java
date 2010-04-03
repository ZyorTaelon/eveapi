package com.beimin.eveapi.member.tracking;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.corporation.member.tracking.ApiMember;
import com.beimin.eveapi.corporation.member.tracking.MemberTrackingParser;
import com.beimin.eveapi.corporation.member.tracking.MemberTrackingResponse;

public class ParserTest {

	@Test
	public void testMemberTrackingParser() throws IOException, SAXException {
		MemberTrackingParser parser = MemberTrackingParser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/MemberTracking.xml");
		MemberTrackingResponse response = parser.getResponse(input);
		assertNotNull(response);
		Set<ApiMember> members = response.getMembers();
		for (ApiMember member : members) {
			System.out.println(member.getName());
		}
		assertTrue("Todo: ", true);
	}
}