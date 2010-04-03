package com.beimin.eveapi.character.notifications;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class NotificationsResponse extends ApiResponse {
	private final Set<ApiNotification> mails = new HashSet<ApiNotification>();

	public void addApiMail(ApiNotification member) {
		mails.add(member);
	}

	public Set<ApiNotification> getApiMails() {
		return mails;
	}
}