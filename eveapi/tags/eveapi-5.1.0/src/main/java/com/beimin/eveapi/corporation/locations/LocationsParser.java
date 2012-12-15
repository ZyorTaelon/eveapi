package com.beimin.eveapi.corporation.locations;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.locations.AbstractLocationsParser;

public class LocationsParser extends AbstractLocationsParser {
	private LocationsParser() {
		super(ApiPath.CORPORATION);
	}

	public static LocationsParser getInstance() {
		return new LocationsParser();
	}
}