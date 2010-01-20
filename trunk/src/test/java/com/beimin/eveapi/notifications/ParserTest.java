package com.beimin.eveapi.notifications;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {

	@Test
	public void testMemberTrackingParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/Notifications.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		Set<ApiNotification> notifications = response.getApiMails();
		assertNotNull(notifications);
		assertEquals(3, notifications.size());
		boolean found = false;
		for (ApiNotification notification : notifications) {
			if(notification.getNotificationID()==295043380L){
				found=true;
				assertEquals(5, notification.getTypeID());
				assertEquals("Alliance war declared", notification.getType());
				assertEquals(1000125L, notification.getSenderID());
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, 2010);
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DAY_OF_MONTH, 14);
				calendar.set(Calendar.HOUR_OF_DAY, 20);
				calendar.set(Calendar.MINUTE, 45);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(), notification.getSentDate());
				assertEquals(false, notification.isRead());
				break;
			}
		}
		assertTrue("Test mail wasn't found.", found);
	}
}