package com.beimin.eveapi.character.contact.notifications;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class ContactNotificationsHandler extends AbstractContentListHandler<ContactNotificationsResponse, EveContactNotification> {

	public ContactNotificationsHandler() {
		super(ContactNotificationsResponse.class);
	}

	@Override
	protected EveContactNotification getItem(Attributes attrs) {
		EveContactNotification contactNotification = new EveContactNotification();
		contactNotification.setNotificationID(getLong(attrs, "notificationID"));
		contactNotification.setSenderID(getLong(attrs, "senderID"));
		contactNotification.setSenderName(getString(attrs, "senderName"));
		contactNotification.setSentDate(getDate(attrs, "sentDate"));
		contactNotification.setMessageData(getString(attrs, "messageData"));
		return contactNotification;
	}
}