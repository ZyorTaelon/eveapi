package com.beimin.eveapi.member;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiAuthorization;

public class ParserTest {

	@Test
	public void testMemberTrackingParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/MemberTracking.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		Set<Member> members = response.getMembers();
		for (Member member : members) {
			System.out.println(member.getName());
		}
		assertTrue("Todo: ", true);
		String requestUrl = parser.getRequestUrl(new ApiAuthorization(271604, 1380128241, "Op5Fd4Skpf5vLOSX61YTPnhTjLS3lyci30wdWPDHgGNhyVXqumdbUet8e9rqXmPi"));
		System.out.println(requestUrl);
	}
}