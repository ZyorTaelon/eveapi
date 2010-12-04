package com.beimin.eveapi.character.mail.messages;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class MailMessagesParser extends AbstractApiParser<MailMessagesResponse> {
	private MailMessagesParser() {
		super(MailMessagesResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAIL_MESSAGES);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiMailMessage.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addApiMail");
		return digester;
	}

	public static MailMessagesParser getInstance() {
		return new MailMessagesParser();
	}

	public MailMessagesResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}