package com.beimin.eveapi.shared.medals;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class MedalsResponse extends ApiResponse {
	private final List<Medal> medals = new ArrayList<Medal>();

	public void addMedal(Medal entry) {
		medals.add(entry);
	}

	public List<Medal> getMedals() {
		return medals;
	}
}