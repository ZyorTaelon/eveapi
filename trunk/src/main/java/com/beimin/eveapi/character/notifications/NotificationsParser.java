package com.beimin.eveapi.character.notifications;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class NotificationsParser extends AbstractApiParser<NotificationsResponse> {
	protected static final String NOTIFICATIONS_URL = "/Notifications.xml.aspx";

	public NotificationsParser() {
		super(NotificationsResponse.class, 1, NOTIFICATIONS_URL);
	}

	public NotificationsResponse getMembers(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.CHARACTER);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiNotification.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addApiMail");
		return digester;
	}

	public static NotificationsParser getInstance() {
		return new NotificationsParser();
	}
}