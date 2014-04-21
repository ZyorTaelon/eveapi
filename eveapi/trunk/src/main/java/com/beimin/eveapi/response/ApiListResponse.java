package com.beimin.eveapi.response;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class ApiListResponse<B> extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private Set<B> items = new LinkedHashSet<B>();

	public void add(B item) {
		items.add(item);
	}

	public Set<B> getAll() {
		return items;
	}
}