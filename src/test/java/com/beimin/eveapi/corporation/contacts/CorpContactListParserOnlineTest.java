package com.beimin.eveapi.corporation.contacts;


import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.corporation.ContactListParser;
import com.beimin.eveapi.response.corporation.ContactListResponse;

public class CorpContactListParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		ContactListParser parser = new ContactListParser();
		ContactListResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}