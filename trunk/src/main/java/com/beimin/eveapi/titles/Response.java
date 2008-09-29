package com.beimin.eveapi.titles;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<Title> titles = new ArrayList<Title>();

	public void addTitle(Title title) {
		titles.add(title);
	}

	public Collection<Title> getTitles() {
		return titles;
	}
}