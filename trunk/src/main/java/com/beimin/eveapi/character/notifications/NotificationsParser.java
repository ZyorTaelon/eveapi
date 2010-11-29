package com.beimin.eveapi.character.notifications;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class NotificationsParser extends AbstractApiParser<NotificationsResponse> {
	private static final String NOTIFICATIONS_URL = "/Notifications";

	private NotificationsParser() {
		super(NotificationsResponse.class, 2, NOTIFICATIONS_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiNotification.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addNotification");
		return digester;
	}

	public NotificationsResponse getNotificationsResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.CHARACTER);
	}

	public Set<ApiNotification> getNotifications(ApiAuth auth) throws IOException, SAXException {
		return getNotificationsResponse(auth).getNotifications();
	}

	public static NotificationsParser getInstance() {
		return new NotificationsParser();
	}
}