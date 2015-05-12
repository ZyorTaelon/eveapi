package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.Notification;
import com.beimin.eveapi.response.pilot.NotificationsResponse;

public class NotificationsHandler extends AbstractContentListHandler<NotificationsResponse, Notification> {

	public NotificationsHandler() {
		super(NotificationsResponse.class);
	}

	@Override
	protected Notification getItem(Attributes attrs) {
		Notification notification = new Notification();
		notification.setNotificationID(getLong(attrs, "notificationID"));
		notification.setSenderID(getLong(attrs, "senderID"));
		notification.setSentDate(getDate(attrs, "sentDate"));
		notification.setTypeID(getInt(attrs, "typeID"));
		notification.setRead(getBoolean(attrs, "read"));
		return notification;
	}
}