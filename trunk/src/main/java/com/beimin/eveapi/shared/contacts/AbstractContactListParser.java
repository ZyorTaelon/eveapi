package com.beimin.eveapi.shared.contacts;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public abstract class AbstractContactListParser<CLR extends AbstractContactListResponse> extends AbstractApiParser<CLR> {
	protected AbstractContactListParser(Class<CLR> responseClass, ApiPath path) {
		super(responseClass, 2, path, ApiPage.CONTACT_LIST);
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

	@Override
	public CLR getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}