package com.beimin.eveapi.killlog;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<ApiKill> kills = new ArrayList<ApiKill>();

	public void addKill(ApiKill entry) {
		kills.add(entry);
	}

	public Collection<ApiKill> getKills() {
		return kills;
	}
}