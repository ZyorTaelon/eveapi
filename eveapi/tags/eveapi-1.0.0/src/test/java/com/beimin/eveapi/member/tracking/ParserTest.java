package com.beimin.eveapi.member.tracking;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {

	@Test
	public void testMemberTrackingParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/MemberTracking.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		Set<ApiMember> members = response.getMembers();
		for (ApiMember member : members) {
			System.out.println(member.getName());
		}
		assertTrue("Todo: ", true);
	}
}