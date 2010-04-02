package com.beimin.eveapi.medals;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class MedalsResponse extends ApiResponse {
	private final List<Medal> medal = new ArrayList<Medal>();

	public void addMedal(Medal entry) {
		medal.add(entry);
	}

	public List<Medal> getMedals() {
		return medal;
	}
}