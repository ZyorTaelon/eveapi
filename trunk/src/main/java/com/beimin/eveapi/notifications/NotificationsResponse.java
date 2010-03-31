package com.beimin.eveapi.notifications;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class NotificationsResponse extends ApiResponse {
	Set<ApiNotification> mails = new HashSet<ApiNotification>();

	public void addApiMail(ApiNotification member) {
		mails.add(member);
	}

	public Set<ApiNotification> getApiMails() {
		return mails;
	}
}