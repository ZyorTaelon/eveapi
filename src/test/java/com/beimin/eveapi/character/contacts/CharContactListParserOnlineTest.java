package com.beimin.eveapi.character.contacts;

import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.pilot.ContactListParser;
import com.beimin.eveapi.response.pilot.ContactListResponse;

public class CharContactListParserOnlineTest extends AbstractOnlineTest {
	
	@Test
	public void getResponse() throws Exception {
		ContactListParser parser = new ContactListParser();
		ContactListResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}