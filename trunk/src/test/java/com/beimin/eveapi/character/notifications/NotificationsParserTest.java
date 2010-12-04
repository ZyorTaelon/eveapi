package com.beimin.eveapi.character.notifications;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.FullApiParserTest;
import com.beimin.eveapi.character.notifications.ApiNotification.NotificationType;

public class NotificationsParserTest extends FullApiParserTest {
	public NotificationsParserTest() {
		super("/char/Notifications.xml.aspx", "/character/Notifications.xml");
	}

	@Test
	public void notificationsParser() throws IOException, SAXException {
		NotificationsParser parser = NotificationsParser.getInstance();
		NotificationsResponse response = parser.getNotificationsResponse(auth);
		assertNotNull(response);
		Set<ApiNotification> notifications = response.getNotifications();
		assertNotNull(notifications);
		assertEquals(3, notifications.size());
		boolean found = false;
		for (ApiNotification notification : notifications) {
			if (notification.getNotificationID() == 295043380L) {
				found = true;
				assertEquals(5, notification.getTypeID());
				assertEquals(NotificationType.ALLIANCE_WAR_DECLARED, notification.getType());
				assertEquals(1000125L, notification.getSenderID());
				assertDate(2010, 1, 14, 20, 45, 0, notification.getSentDate());
				assertEquals(false, notification.isRead());
				break;
			}
		}
		assertTrue("Test mail wasn't found.", found);
	}
}