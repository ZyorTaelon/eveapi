package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.character.NotificationsHandler;
import com.beimin.eveapi.model.character.Notification;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.character.NotificationsResponse;

public class NotificationsParser extends AbstractListParser<NotificationsHandler, NotificationsResponse, Notification> {
    public NotificationsParser() {
        super(NotificationsResponse.class, 2, ApiPath.CHARACTER, ApiPage.NOTIFICATIONS, NotificationsHandler.class);
    }

    @Override
    public NotificationsResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
