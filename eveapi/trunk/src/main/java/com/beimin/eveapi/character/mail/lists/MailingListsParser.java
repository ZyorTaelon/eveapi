package com.beimin.eveapi.character.mail.lists;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class MailingListsParser extends AbstractListParser<MailingListsHandler, MailingListsResponse, ApiMailingList> {
	public MailingListsParser() {
		super(MailingListsResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAILING_LISTS, MailingListsHandler.class);
	}

	@Override
	public MailingListsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}