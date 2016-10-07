package com.beimin.eveapi.character.notifications;


import com.beimin.eveapi.AbstractOnlineTest;
import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.model.pilot.Notification;
import com.beimin.eveapi.parser.pilot.NotificationTextsParser;
import com.beimin.eveapi.parser.pilot.NotificationsParser;
import com.beimin.eveapi.response.pilot.NotificationTextsResponse;
import com.beimin.eveapi.response.pilot.NotificationsResponse;

public class NotificationTextsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		NotificationsParser notificationsParser = new NotificationsParser();
		NotificationsResponse notificationsResponse = notificationsParser.getResponse(getPilot());
		testResponse(notificationsResponse);
		Set<Notification> notifications = notificationsResponse.getAll();
		test(notifications);
		NotificationTextsParser parser = new NotificationTextsParser();
		for (Notification notification : notifications) {
			NotificationTextsResponse response = parser.getResponse(getPilot(), notification.getNotificationID());
			testResponse(response);
		}
	}

}