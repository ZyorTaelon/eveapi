package com.beimin.eveapi.character.mail.lists;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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
	public MailingListsResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}