package com.beimin.eveapi.character.mail.lists;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class MailingListsParser extends AbstractApiParser<MailingListsResponse> {
	private static final String MAILING_LIST_URL = "/MailingList";

	private MailingListsParser() {
		super(MailingListsResponse.class, 2, MAILING_LIST_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiMailingList.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMailingList");
		return digester;
	}

	public MailingListsResponse getMailingListsResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.CHARACTER);
	}
	
	public Set<ApiMailingList> getMailingLists(ApiAuth auth) throws IOException, SAXException {
		return getMailingListsResponse(auth).getMailingLists();
	}
	
	public static MailingListsParser getInstance() {
		return new MailingListsParser();
	}
}