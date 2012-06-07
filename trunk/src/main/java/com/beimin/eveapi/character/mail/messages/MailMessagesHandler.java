package com.beimin.eveapi.character.mail.messages;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class MailMessagesHandler extends AbstractContentListHandler<MailMessagesResponse, ApiMailMessage> {

	public MailMessagesHandler() {
		super(MailMessagesResponse.class);
	}

	@Override
	protected ApiMailMessage getItem(Attributes attrs) {
		ApiMailMessage mailMessage = new ApiMailMessage();
		mailMessage.setMessageID(getLong(attrs, "messageID"));
		mailMessage.setRead(getBoolean(attrs, "read"));
		mailMessage.setSenderID(getLong(attrs, "senderID"));
		mailMessage.setSentDate(getDate(attrs, "sentDate"));
		mailMessage.setTitle(getString(attrs, "title"));
		mailMessage.setToCharacterIDs(getString(attrs, "toCharacterIDs"));
		mailMessage.setToCorpOrAllianceID(getLong(attrs, "toCorpOrAllianceID"));
		mailMessage.setToListIDs(getString(attrs, "toListID"));
		return mailMessage;
	}

}