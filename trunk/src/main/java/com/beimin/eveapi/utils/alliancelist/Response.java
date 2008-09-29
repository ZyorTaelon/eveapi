package com.beimin.eveapi.utils.alliancelist;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<Alliance> alliances = new ArrayList<Alliance>();

	public void addAlliance(Alliance alliance) {
		alliances.add(alliance);
	}

	public Collection<Alliance> getAlliances() {
		return alliances;
	}
}