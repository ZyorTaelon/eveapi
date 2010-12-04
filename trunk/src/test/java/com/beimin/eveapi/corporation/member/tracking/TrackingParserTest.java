package com.beimin.eveapi.corporation.member.tracking;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class TrackingParserTest extends FullAuthParserTest {
	public TrackingParserTest() {
		super(ApiPath.CORPORATION, ApiPage.MEMBER_TRACKING);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		MemberTrackingParser parser = MemberTrackingParser.getInstance();
		MemberTrackingResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<ApiMember> members = response.getMembers();
		for (ApiMember member : members) {
			System.out.println(member.getName());
		}
		assertTrue("Todo: ", true);
	}
}