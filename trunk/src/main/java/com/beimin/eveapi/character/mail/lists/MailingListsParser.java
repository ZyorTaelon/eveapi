package com.beimin.eveapi.character.mail.lists;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class MailingListsParser extends AbstractApiParser<MailingListsResponse> {
	private MailingListsParser() {
		super(MailingListsResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAILING_LISTS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiMailingList.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMailingList");
		return digester;
	}

	public static MailingListsParser getInstance() {
		return new MailingListsParser();
	}

	@Override
	public MailingListsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}