package com.beimin.eveapi.corporation.member.security.log;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.MemberSecurityLogParser;
import com.beimin.eveapi.response.corporation.MemberSecurityLogResponse;

public class SecurityLogParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		MemberSecurityLogParser parser = new MemberSecurityLogParser();
		MemberSecurityLogResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}