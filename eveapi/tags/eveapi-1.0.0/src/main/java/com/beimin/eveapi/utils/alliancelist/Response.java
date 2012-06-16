package com.beimin.eveapi.utils.alliancelist;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<ApiAlliance> alliances = new ArrayList<ApiAlliance>();

	public void addAlliance(ApiAlliance alliance) {
		alliances.add(alliance);
	}

	public Collection<ApiAlliance> getAlliances() {
		return alliances;
	}
}