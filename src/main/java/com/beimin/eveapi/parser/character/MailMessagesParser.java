package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.character.MailMessagesHandler;
import com.beimin.eveapi.model.character.MailMessage;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.character.MailMessagesResponse;

public class MailMessagesParser extends AbstractListParser<MailMessagesHandler, MailMessagesResponse, MailMessage> {
    public MailMessagesParser() {
        super(MailMessagesResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAIL_MESSAGES, MailMessagesHandler.class);
    }

    @Override
    public MailMessagesResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
