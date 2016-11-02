package com.beimin.eveapi.handler.character;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.character.MailMessage;
import com.beimin.eveapi.response.character.MailMessagesResponse;

public class MailMessagesHandler extends AbstractContentListHandler<MailMessagesResponse, MailMessage> {

    public MailMessagesHandler() {
        super(MailMessagesResponse.class);
    }

    @Override
    protected MailMessage getItem(final Attributes attrs) {
        final MailMessage mailMessage = new MailMessage();
        saveAttributes(MailMessage.class, attrs);
        mailMessage.setMessageID(getLong(attrs, "messageID"));
        mailMessage.setSenderID(getLong(attrs, "senderID"));
        mailMessage.setSentDate(getDate(attrs, "sentDate"));
        mailMessage.setTitle(getString(attrs, "title"));
        mailMessage.setToCharacterIDs(getString(attrs, "toCharacterIDs"));
        mailMessage.setToCorpOrAllianceID(getLong(attrs, "toCorpOrAllianceID"));
        mailMessage.setToListIDs(getString(attrs, "toListID"));
        mailMessage.setSenderTypeID(getInt(attrs, "senderTypeID"));
        mailMessage.setSenderName(getString(attrs, "senderName"));
        return mailMessage;
    }

}
