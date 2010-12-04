package com.beimin.eveapi.character.notifications;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class NotificationsParser extends AbstractApiParser<NotificationsResponse> {
	private NotificationsParser() {
		super(NotificationsResponse.class, 2, ApiPath.CHARACTER, ApiPage.NOTIFICATIONS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiNotification.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addNotification");
		return digester;
	}

	public static NotificationsParser getInstance() {
		return new NotificationsParser();
	}

	public NotificationsResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}