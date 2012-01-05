package com.beimin.eveapi.character.notifications;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class NotificationsHandler extends AbstractContentListHandler<NotificationsResponse, ApiNotification> {

	public NotificationsHandler() {
		super(NotificationsResponse.class);
	}

	@Override
	protected ApiNotification getItem(Attributes attrs) {
		ApiNotification notification = new ApiNotification();
		notification.setNotificationID(getLong(attrs, "notificationID"));
		notification.setSenderID(getLong(attrs, "senderID"));
		notification.setSentDate(getDate(attrs, "sentDate"));
		notification.setTypeID(getInt(attrs, "typeID"));
		notification.setRead(getBoolean(attrs, "read"));
		return notification;
	}
}