package com.beimin.eveapi.character.mail.lists;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class MailingListsParser extends AbstractListParser<MailingListsResponse, ApiMailingList> {
	private MailingListsParser() {
		super(MailingListsResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAILING_LISTS, ApiMailingList.class);
	}

	public static MailingListsParser getInstance() {
		return new MailingListsParser();
	}

	@Override
	public MailingListsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}