package com.beimin.eveapi.character.notifications.texts;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.StringUtils;

public class NotificationTextsParser extends AbstractListParser<NotificationTextsHandler, NotificationTextsResponse, ApiNotificationText> {
	public NotificationTextsParser() {
		super(NotificationTextsResponse.class, 2, ApiPath.CHARACTER, ApiPage.NOTIFICATION_TEXTS, NotificationTextsHandler.class);
	}

	public NotificationTextsResponse getResponse(ApiAuth<?> auth, long... notificationIDs) throws ApiException {
		return super.getResponse(auth, "ids", StringUtils.join(",", notificationIDs));
	}
}