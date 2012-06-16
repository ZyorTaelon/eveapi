package com.beimin.eveapi.character.notifications;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class NotificationsParser extends AbstractListParser<NotificationsResponse, ApiNotification> {
	private NotificationsParser() {
		super(NotificationsResponse.class, 2, ApiPath.CHARACTER, ApiPage.NOTIFICATIONS, ApiNotification.class);
	}

	public static NotificationsParser getInstance() {
		return new NotificationsParser();
	}

	@Override
	public NotificationsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}