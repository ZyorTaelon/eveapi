package com.beimin.eveapi.character.mail.messages;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

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

	@Override
	public MailMessagesResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}