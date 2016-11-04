package com.beimin.eveapi.handler.character;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.character.ContactNotification;
import com.beimin.eveapi.response.character.ContactNotificationsResponse;

public class ContactNotificationsHandler extends AbstractContentListHandler<ContactNotificationsResponse, ContactNotification> {

    public ContactNotificationsHandler() {
        super(new ContactNotificationsResponse());
    }

    @Override
    protected ContactNotification getItem(final Attributes attrs) {
        final ContactNotification contactNotification = new ContactNotification();
        saveAttributes(ContactNotification.class, attrs);
        contactNotification.setNotificationID(getLong(attrs, "notificationID"));
        contactNotification.setSenderID(getLong(attrs, "senderID"));
        contactNotification.setSenderName(getString(attrs, "senderName"));
        contactNotification.setSentDate(getDate(attrs, "sentDate"));
        contactNotification.setMessageData(getString(attrs, "messageData"));
        return contactNotification;
    }
}
