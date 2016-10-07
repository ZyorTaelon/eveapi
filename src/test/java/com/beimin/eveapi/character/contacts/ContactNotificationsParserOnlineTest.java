package com.beimin.eveapi.character.contacts;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.ContactNotificationsParser;
import com.beimin.eveapi.response.pilot.ContactNotificationsResponse;

public class ContactNotificationsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		ContactNotificationsParser parser = new ContactNotificationsParser();
		ContactNotificationsResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}