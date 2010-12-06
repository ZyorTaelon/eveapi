package com.beimin.eveapi.shared.medals;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.core.ApiResponse;

public class MedalsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<Medal> medals = new ArrayList<Medal>();

	public void addMedal(Medal entry) {
		medals.add(entry);
	}

	public List<Medal> getMedals() {
		return medals;
	}
}