package com.beimin.eveapi.shared.contacts;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractContactListParser<CLR extends AbstractContactListResponse> extends AbstractApiParser<CLR> {
	protected static final String CONTACT_LIST_URL = "/ContactList";

	protected AbstractContactListParser(Class<CLR> responseClass, Path path) {
		super(responseClass, 2, path, CONTACT_LIST_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset", ContactList.class);
		digester.addSetProperties("eveapi/result/rowset");
		digester.addObjectCreate("eveapi/result/rowset/row", ApiContact.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		digester.addSetNext("eveapi/result/rowset", "addContactList");
		return digester;
	}

	public CLR getContactListResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}
}