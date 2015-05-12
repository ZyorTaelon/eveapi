package com.beimin.eveapi.parser.pilot;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.pilot.NotificationTextsHandler;
import com.beimin.eveapi.model.pilot.NotificationText;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.pilot.NotificationTextsResponse;
import com.beimin.eveapi.utils.StringUtils;

public class NotificationTextsParser extends AbstractListParser<NotificationTextsHandler, NotificationTextsResponse, NotificationText> {
	public NotificationTextsParser() {
		super(NotificationTextsResponse.class, 2, ApiPath.CHARACTER, ApiPage.NOTIFICATION_TEXTS, NotificationTextsHandler.class);
	}

	public NotificationTextsResponse getResponse(ApiAuth<?> auth, long... notificationIDs) throws ApiException {
		return super.getResponse(auth, "ids", StringUtils.join(",", notificationIDs));
	}
}