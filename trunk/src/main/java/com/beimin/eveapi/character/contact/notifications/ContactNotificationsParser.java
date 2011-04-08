package com.beimin.eveapi.character.contact.notifications;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ContactNotificationsParser extends AbstractListParser<ContactNotificationsResponse, EveContactNotification> {
	protected ContactNotificationsParser() {
		super(ContactNotificationsResponse.class, 2, ApiPath.CHARACTER, ApiPage.CONTACT_NOTIFICATIONS, EveContactNotification.class);
	}

	public static ContactNotificationsParser getInstance() {
		return new ContactNotificationsParser();
	}

	@Override
	public ContactNotificationsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}