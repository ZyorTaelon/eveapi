package com.beimin.eveapi.character.notifications;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.NotificationsParser;
import com.beimin.eveapi.response.pilot.NotificationsResponse;

public class NotificationsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		NotificationsParser parser = new NotificationsParser();
		NotificationsResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}