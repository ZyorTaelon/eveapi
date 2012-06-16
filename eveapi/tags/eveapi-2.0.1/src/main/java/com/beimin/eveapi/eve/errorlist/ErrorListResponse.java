package com.beimin.eveapi.eve.errorlist;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class ErrorListResponse extends ApiResponse {
	private final Collection<ApiErrorListItem> apiErrorListItems = new ArrayList<ApiErrorListItem>();

	public void addApiErrorListItem(ApiErrorListItem errorListItem) {
		apiErrorListItems.add(errorListItem);
	}

	public Collection<ApiErrorListItem> getApiErrorListItems() {
		return apiErrorListItems;
	}
}