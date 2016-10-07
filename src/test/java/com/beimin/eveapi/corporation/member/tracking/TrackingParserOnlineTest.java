package com.beimin.eveapi.corporation.member.tracking;

import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.MemberTrackingParser;
import com.beimin.eveapi.response.corporation.MemberTrackingResponse;

public class TrackingParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		MemberTrackingParser parser = new MemberTrackingParser();
		MemberTrackingResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

	@Test
	public void getExtendedResponse() throws Exception {
		MemberTrackingParser parser = new MemberTrackingParser();
		MemberTrackingResponse response = parser.getExtendedResponse(getCorp());
		testResponse(response);
	}

}