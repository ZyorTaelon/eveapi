package com.beimin.eveapi.handler.character;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.character.Notification;
import com.beimin.eveapi.response.character.NotificationsResponse;

public class NotificationsHandler extends AbstractContentListHandler<NotificationsResponse, Notification> {

    public NotificationsHandler() {
        super(NotificationsResponse.class);
    }

    @Override
    protected Notification getItem(final Attributes attrs) {
        final Notification notification = new Notification();
        saveAttributes(Notification.class, attrs);
        notification.setNotificationID(getLong(attrs, "notificationID"));
        notification.setSenderID(getLong(attrs, "senderID"));
        notification.setSenderName(getString(attrs, "senderName"));
        notification.setSentDate(getDate(attrs, "sentDate"));
        notification.setTypeID(getInt(attrs, "typeID"));
        notification.setRead(getBoolean(attrs, "read"));
        return notification;
    }
}
