package com.beimin.eveapi.parser.pilot;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.pilot.NotificationsHandler;
import com.beimin.eveapi.model.pilot.Notification;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.pilot.NotificationsResponse;

public class NotificationsParser extends AbstractListParser<NotificationsHandler, NotificationsResponse, Notification> {
	public NotificationsParser() {
		super(NotificationsResponse.class, 2, ApiPath.CHARACTER, ApiPage.NOTIFICATIONS, NotificationsHandler.class);
	}

	@Override
	public NotificationsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}