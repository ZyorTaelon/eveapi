package com.beimin.eveapi.character.notifications;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.character.notifications.ApiNotification.NotificationType;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class NotificationsParserTest extends FullAuthParserTest {
	public NotificationsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.NOTIFICATIONS);
	}

	@Test
	public void getResponse() throws ApiException {
		NotificationsParser parser = NotificationsParser.getInstance();
		NotificationsResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<ApiNotification> notifications = response.getAll();
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