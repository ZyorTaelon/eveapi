package com.beimin.eveapi.map.factwar.systems;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class FacWarSystemsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<ApiFacWarSystem> systems = new ArrayList<ApiFacWarSystem>();

	public void addSystem(ApiFacWarSystem system) {
		systems.add(system);
	}

	public List<ApiFacWarSystem> getSystems() {
		return systems;
	}
}