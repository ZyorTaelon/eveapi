package com.beimin.eveapi.corporation.starbase.list;

public enum ApiStarbaseState {
	UNKNOWN("Unknown"), ANCHORED("Anchored"), ONLINING("Onlining"), REINFORCED("Reinforced"), ONLINE("Online");
	private final String name;

	private ApiStarbaseState(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
