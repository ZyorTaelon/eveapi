package com.beimin.eveapi.corporation.member.security;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.MemberSecurityParser;
import com.beimin.eveapi.response.corporation.MemberSecurityResponse;

public class SecurityParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		MemberSecurityParser parser = new MemberSecurityParser();
		MemberSecurityResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}