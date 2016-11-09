package com.beimin.eveapi.character.contacts;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.character.ContactNotification;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.ContactNotificationsParser;
import com.beimin.eveapi.response.character.ContactNotificationsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ContactNotificationsParserTest extends FullAuthParserTest {
    public ContactNotificationsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.CONTACT_NOTIFICATIONS);
    }

    @Test
    public void getResponse() throws ApiException {
        final ContactNotificationsParser parser = new ContactNotificationsParser();
        final ContactNotificationsResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final List<ContactNotification> contactNotifications = response.getAll();
        assertEquals(1, contactNotifications.size());
        final ContactNotification contactNotification = contactNotifications.iterator().next();
        assertEquals(308734131, contactNotification.getNotificationID());
        assertEquals(797400947L, contactNotification.getSenderID());
        assertEquals("CCP Garthagk", contactNotification.getSenderName());
        assertDate(2010, 5, 29, 23, 4, 0, contactNotification.getSentDate());
        assertEquals("level: 10\nmessage: Hi, I want to social network with you!\n", contactNotification.getMessageData());
    }
}
