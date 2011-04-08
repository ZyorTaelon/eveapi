package com.beimin.eveapi.shared.standings;

import java.util.ArrayList;

public class StandingsList extends ArrayList<ApiStanding> {
	private static final long serialVersionUID = 1L;
	public String name;
	public String key;
	public String columns;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}
}