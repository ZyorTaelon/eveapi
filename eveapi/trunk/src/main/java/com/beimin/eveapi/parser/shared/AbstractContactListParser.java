package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.shared.ContactListHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

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