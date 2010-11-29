package com.beimin.eveapi.character.contacts;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ContactNotificationsParserTest {

	@Test
	public void contactListParser() throws IOException, SAXException {
		ContactNotificationsParser parser = ContactNotificationsParser.getInstance();
		InputStream input = ContactNotificationsParserTest.class
				.getResourceAsStream("/character/ContactNotifications.xml");
		ContactNotificationsResponse response = parser.getResponse(input);
		assertNotNull(response);
		List<ApiContactNotification> contactNotifications = response.getContactNotifications();
		assertEquals(1, contactNotifications.size());
		ApiContactNotification contactNotification = contactNotifications.iterator().next();
		assertEquals(308734131, contactNotification.getNotificationID());
		assertEquals(797400947L, contactNotification.getSenderID());
		assertEquals("CCP Garthagk", contactNotification.getSenderName());
		assertDate(2010, 5, 29, 23, 4, 0, contactNotification.getSentDate());
		assertEquals("level: 10\nmessage: Hi, I want to social network with you!\n",
				contactNotification.getMessageData());
	}
}