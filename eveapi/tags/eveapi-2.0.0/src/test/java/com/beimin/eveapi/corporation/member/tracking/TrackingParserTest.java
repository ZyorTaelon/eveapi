package com.beimin.eveapi.corporation.member.tracking;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

public class TrackingParserTest {

	@Test
	public void memberTrackingParser() throws IOException, SAXException {
		MemberTrackingParser parser = MemberTrackingParser.getInstance();
		InputStream input = TrackingParserTest.class.getResourceAsStream("/corporation/MemberTracking.xml");
		MemberTrackingResponse response = parser.getResponse(input);
		assertNotNull(response);
		Set<ApiMember> members = response.getMembers();
		for (ApiMember member : members) {
			System.out.println(member.getName());
		}
		assertTrue("Todo: ", true);
	}
}