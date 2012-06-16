package com.beimin.eveapi.character.mailmessages;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class EveMailParser extends AbstractApiParser<EveMaiResponse> {
	private static final String MAIL_MESSAGES_URL = "/MailMessages.xml.aspx";

	private EveMailParser() {
		super(EveMaiResponse.class, 2, MAIL_MESSAGES_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiEveMai.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addApiMail");
		return digester;
	}

	public EveMaiResponse getEveMaiResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.CHARACTER);
	}
	
	public Set<ApiEveMai> getEveMails(ApiAuth auth) throws IOException, SAXException {
		return getEveMaiResponse(auth).getApiMails();
	}
	
	public static EveMailParser getInstance() {
		return new EveMailParser();
	}
}