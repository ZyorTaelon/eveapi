package com.beimin.eveapi.model.corporation;

public enum StarbaseState {
	UNKNOWN("Unknown"), ANCHORED("Anchored"), ONLINING("Onlining"), REINFORCED("Reinforced"), ONLINE("Online");
	private final String name;

	private StarbaseState(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
