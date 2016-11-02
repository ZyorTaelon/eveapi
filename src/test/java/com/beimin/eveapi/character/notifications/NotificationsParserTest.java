package com.beimin.eveapi.character.notifications;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.character.Notification;
import com.beimin.eveapi.model.character.Notification.NotificationType;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.NotificationsParser;
import com.beimin.eveapi.response.character.NotificationsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class NotificationsParserTest extends FullAuthParserTest {
    public NotificationsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.NOTIFICATIONS);
    }

    @Test
    public void getResponse() throws ApiException {
        final NotificationsParser parser = new NotificationsParser();
        final NotificationsResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final Set<Notification> notifications = response.getAll();
        assertNotNull(notifications);
        assertEquals(3, notifications.size());
        boolean found = false;
        for (final Notification notification : notifications) {
            if (notification.getNotificationID() == 295043380L) {
                found = true;
                assertEquals(5, notification.getTypeID());
                assertEquals(NotificationType.ALLIANCE_WAR_DECLARED, notification.getType());
                assertEquals(1000125L, notification.getSenderID());
                assertDate(2010, 1, 14, 20, 45, 0, notification.getSentDate());
                assertEquals(false, notification.isRead());
                assertEquals("CONCORD", notification.getSenderName());
                break;
            }
        }
        assertTrue("Test mail wasn't found.", found);
    }
}
