package com.beimin.eveapi.character.notifications;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class NotificationsResponse extends ApiResponse {
	private final Set<ApiNotification> notifications = new HashSet<ApiNotification>();

	public void addNotification(ApiNotification member) {
		notifications.add(member);
	}

	public Set<ApiNotification> getNotifications() {
		return notifications;
	}
}