package com.beimin.eveapi.character.notifications;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class NotificationsParser extends AbstractListParser<NotificationsHandler, NotificationsResponse, ApiNotification> {
	public NotificationsParser() {
		super(NotificationsResponse.class, 2, ApiPath.CHARACTER, ApiPage.NOTIFICATIONS, NotificationsHandler.class);
	}

	@Override
	public NotificationsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}