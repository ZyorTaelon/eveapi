package com.beimin.eveapi.character.notifications;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.character.Notification;
import com.beimin.eveapi.parser.character.NotificationTextsParser;
import com.beimin.eveapi.parser.character.NotificationsParser;
import com.beimin.eveapi.response.character.NotificationTextsResponse;
import com.beimin.eveapi.response.character.NotificationsResponse;

public class NotificationTextsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final NotificationsParser notificationsParser = new NotificationsParser();
        final NotificationsResponse notificationsResponse = notificationsParser.getResponse(getCharacter());
        final List<Notification> notifications = notificationsResponse.getAll();
        test(notifications);
        final NotificationTextsParser parser = new NotificationTextsParser();
        prepareParser(parser);
        for (final Notification notification : notifications) {
            final NotificationTextsResponse response = parser.getResponse(getCharacter(), notification.getNotificationID());
            testResponse(response);
        }
    }

}
