package com.beimin.eveapi.character.locations;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.locations.AbstractLocationsParser;

public class LocationsParser extends AbstractLocationsParser {
	private LocationsParser() {
		super(ApiPath.CHARACTER);
	}

	public static LocationsParser getInstance() {
		return new LocationsParser();
	}
}