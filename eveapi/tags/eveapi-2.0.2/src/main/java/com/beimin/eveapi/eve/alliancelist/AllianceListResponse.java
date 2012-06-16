package com.beimin.eveapi.eve.alliancelist;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class AllianceListResponse extends ApiResponse {
	private final Collection<ApiAlliance> alliances = new ArrayList<ApiAlliance>();

	public void addAlliance(ApiAlliance alliance) {
		alliances.add(alliance);
	}

	public Collection<ApiAlliance> getAlliances() {
		return alliances;
	}
}