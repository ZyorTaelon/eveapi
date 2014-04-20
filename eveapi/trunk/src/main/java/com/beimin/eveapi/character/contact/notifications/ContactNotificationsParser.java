package com.beimin.eveapi.character.contact.notifications;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class ContactNotificationsParser extends AbstractListParser<ContactNotificationsHandler, ContactNotificationsResponse, EveContactNotification> {
	public ContactNotificationsParser() {
		super(ContactNotificationsResponse.class, 2, ApiPath.CHARACTER, ApiPage.CONTACT_NOTIFICATIONS, ContactNotificationsHandler.class);
	}

	@Override
	public ContactNotificationsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}