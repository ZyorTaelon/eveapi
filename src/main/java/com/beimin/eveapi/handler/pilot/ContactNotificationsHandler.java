package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.ContactNotification;
import com.beimin.eveapi.response.pilot.ContactNotificationsResponse;

public class ContactNotificationsHandler extends AbstractContentListHandler<ContactNotificationsResponse, ContactNotification> {

	public ContactNotificationsHandler() {
		super(ContactNotificationsResponse.class);
	}

	@Override
	protected ContactNotification getItem(Attributes attrs) {
		ContactNotification contactNotification = new ContactNotification();
		contactNotification.setNotificationID(getLong(attrs, "notificationID"));
		contactNotification.setSenderID(getLong(attrs, "senderID"));
		contactNotification.setSenderName(getString(attrs, "senderName"));
		contactNotification.setSentDate(getDate(attrs, "sentDate"));
		contactNotification.setMessageData(getString(attrs, "messageData"));
		return contactNotification;
	}
}