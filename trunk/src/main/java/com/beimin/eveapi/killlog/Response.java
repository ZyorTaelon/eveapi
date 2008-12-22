package com.beimin.eveapi.killlog;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<Kill> kills = new ArrayList<Kill>();

	public void addKill(Kill entry) {
		kills.add(entry);
	}

	public Collection<Kill> getKills() {
		return kills;
	}
}