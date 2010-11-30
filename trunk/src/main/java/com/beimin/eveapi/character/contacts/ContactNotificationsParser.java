package com.beimin.eveapi.character.contacts;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class ContactNotificationsParser extends AbstractApiParser<ContactNotificationsResponse> {
	private static final String CONTACT_NOTIFICATIONS_URL = "/ContactNotifications";

	protected ContactNotificationsParser() {
		super(ContactNotificationsResponse.class, 2, Path.CHARACTER, CONTACT_NOTIFICATIONS_URL);
	}

	public static ContactNotificationsParser getInstance() {
		return new ContactNotificationsParser();
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiContactNotification.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	public ContactNotificationsResponse getContactNotificationsResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}
}