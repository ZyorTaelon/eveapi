package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.character.MailingListsHandler;
import com.beimin.eveapi.model.character.MailingList;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.character.MailingListsResponse;

public class MailingListsParser extends AbstractListParser<MailingListsHandler, MailingListsResponse, MailingList> {
    public MailingListsParser() {
        super(MailingListsResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAILING_LISTS, MailingListsHandler.class);
    }

    @Override
    public MailingListsResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
