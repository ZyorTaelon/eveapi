package com.beimin.eveapi.character.notifications;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.pilot.NotificationText;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.NotificationTextsParser;
import com.beimin.eveapi.response.pilot.NotificationTextsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class NotificationTextsParserTest extends FullAuthParserTest {
	public NotificationTextsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.NOTIFICATION_TEXTS);
	}

	@Test
	public void getResponse() throws ApiException {
		NotificationTextsParser parser = new NotificationTextsParser();
		NotificationTextsResponse response = parser.getResponse(auth, 374106507L);
		assertNotNull(response);
		Set<NotificationText> notifications = response.getAll();
		assertNotNull(notifications);
		assertEquals(5, notifications.size());
		boolean found = false;
		for (NotificationText notification : notifications) {
			if (notification.getNotificationID() == 374106507L) {
				found = true;
				assertEquals("againstID: 673381830\n"+
					         "cost: null\n"+
					         "declaredByID: 98105019\n"+
					         "delayHours: null\n"+
					         "hostileState: null", notification.getText());
				break;
			}
		}
		assertTrue("Test mail wasn't found.", found);
	}
}