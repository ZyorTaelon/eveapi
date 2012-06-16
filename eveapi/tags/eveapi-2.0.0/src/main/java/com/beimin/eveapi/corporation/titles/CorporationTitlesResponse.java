package com.beimin.eveapi.corporation.titles;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class CorporationTitlesResponse extends ApiResponse {
	private final Collection<ApiTitle> titles = new ArrayList<ApiTitle>();

	public void addTitle(ApiTitle title) {
		titles.add(title);
	}

	public Collection<ApiTitle> getTitles() {
		return titles;
	}
}