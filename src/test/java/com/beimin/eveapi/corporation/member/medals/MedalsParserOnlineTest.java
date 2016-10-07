package com.beimin.eveapi.corporation.member.medals;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.MemberMedalsParser;
import com.beimin.eveapi.response.corporation.MemberMedalsResponse;

public class MedalsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		MemberMedalsParser parser = new MemberMedalsParser();
		MemberMedalsResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}