package com.beimin.eveapi.character.mailmessages;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class EveMailParser extends AbstractApiParser<EveMaiResponse> {
	protected static final String MAIL_MESSAGES_URL = "/MailMessages.xml.aspx";

	public EveMailParser() {
		super(EveMaiResponse.class, 1, MAIL_MESSAGES_URL);
	}

	public EveMaiResponse getMembers(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.CHARACTER);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiEveMai.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addApiMail");
		return digester;
	}

	public static EveMailParser getInstance() {
		return new EveMailParser();
	}
}