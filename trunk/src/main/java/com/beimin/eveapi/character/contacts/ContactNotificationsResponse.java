package com.beimin.eveapi.character.contacts;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.core.ApiResponse;

public class ContactNotificationsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private List<ApiContactNotification> contactNotifications = new ArrayList<ApiContactNotification>();

	public void add(ApiContactNotification notification) {
		contactNotifications.add(notification);
	}

	public List<ApiContactNotification> getContactNotifications() {
		return contactNotifications;
	}
}