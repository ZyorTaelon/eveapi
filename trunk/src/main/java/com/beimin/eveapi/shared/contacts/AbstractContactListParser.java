package com.beimin.eveapi.shared.contacts;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

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
	public CLR getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}