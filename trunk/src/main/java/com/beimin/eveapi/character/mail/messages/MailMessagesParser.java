package com.beimin.eveapi.character.mail.messages;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class MailMessagesParser extends AbstractApiParser<MailMessagesResponse> {
	private static final String MAIL_MESSAGES_URL = "/MailMessages";

	private MailMessagesParser() {
		super(MailMessagesResponse.class, 2, Path.CHARACTER, MAIL_MESSAGES_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiMailMessage.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addApiMail");
		return digester;
	}

	public MailMessagesResponse getMailMessagesResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	public Set<ApiMailMessage> getMailMessages(ApiAuth auth) throws IOException, SAXException {
		return getMailMessagesResponse(auth).getApiMails();
	}

	public static MailMessagesParser getInstance() {
		return new MailMessagesParser();
	}
}