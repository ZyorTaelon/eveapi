package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.character.ContactNotificationsHandler;
import com.beimin.eveapi.model.character.ContactNotification;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.character.ContactNotificationsResponse;

public class ContactNotificationsParser extends AbstractListParser<ContactNotificationsHandler, ContactNotificationsResponse, ContactNotification> {
    public ContactNotificationsParser() {
        super(ContactNotificationsResponse.class, 2, ApiPath.CHARACTER, ApiPage.CONTACT_NOTIFICATIONS, ContactNotificationsHandler.class);
    }

    @Override
    public ContactNotificationsResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
