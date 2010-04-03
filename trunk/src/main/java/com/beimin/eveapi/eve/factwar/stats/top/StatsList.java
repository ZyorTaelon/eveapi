package com.beimin.eveapi.eve.factwar.stats.top;

import java.util.ArrayList;

public class StatsList<E> extends ArrayList<E> {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}