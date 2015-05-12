package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.MailMessage;
import com.beimin.eveapi.response.pilot.MailMessagesResponse;

public class MailMessagesHandler extends AbstractContentListHandler<MailMessagesResponse, MailMessage> {

	public MailMessagesHandler() {
		super(MailMessagesResponse.class);
	}

	@Override
	protected MailMessage getItem(Attributes attrs) {
		MailMessage mailMessage = new MailMessage();
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