package com.beimin.eveapi.character.notifications;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class NotificationsParser extends AbstractApiParser<NotificationsResponse> {
	private NotificationsParser() {
		super(NotificationsResponse.class, 2, ApiPath.CHARACTER, ApiPage.NOTIFICATIONS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiNotification.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addNotification");
		return digester;
	}

	public static NotificationsParser getInstance() {
		return new NotificationsParser();
	}

	@Override
	public NotificationsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}