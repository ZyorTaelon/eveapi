package com.beimin.eveapi.shared.contacts;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractContactListParser<CLR extends AbstractContactListResponse> extends AbstractApiParser<CLR> {
	protected AbstractContactListParser(Class<CLR> responseClass, ApiPath path) {
		super(responseClass, 2, path, ApiPage.CONTACT_LIST);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new ContactListHandler<CLR>(clazz);
	}

	@Override
	public CLR getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}