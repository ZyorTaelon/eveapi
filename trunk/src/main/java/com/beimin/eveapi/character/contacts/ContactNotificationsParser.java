package com.beimin.eveapi.character.contacts;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class ContactNotificationsParser extends AbstractApiParser<ContactNotificationsResponse> {
	protected ContactNotificationsParser() {
		super(ContactNotificationsResponse.class, 2, ApiPath.CHARACTER, ApiPage.CONTACT_NOTIFICATIONS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiContactNotification.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	public static ContactNotificationsParser getInstance() {
		return new ContactNotificationsParser();
	}

	public ContactNotificationsResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}