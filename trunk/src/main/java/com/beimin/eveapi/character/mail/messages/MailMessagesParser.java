package com.beimin.eveapi.character.mail.messages;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class MailMessagesParser extends AbstractListParser<MailMessagesResponse, ApiMailMessage> {
	private MailMessagesParser() {
		super(MailMessagesResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAIL_MESSAGES, ApiMailMessage.class);
	}

	public static MailMessagesParser getInstance() {
		return new MailMessagesParser();
	}

	@Override
	public MailMessagesResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}