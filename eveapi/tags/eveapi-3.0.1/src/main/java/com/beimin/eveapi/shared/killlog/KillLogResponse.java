package com.beimin.eveapi.shared.killlog;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.core.ApiResponse;

public class KillLogResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Collection<ApiKill> kills = new ArrayList<ApiKill>();

	public void addKill(ApiKill entry) {
		kills.add(entry);
	}

	public Collection<ApiKill> getKills() {
		return kills;
	}
}