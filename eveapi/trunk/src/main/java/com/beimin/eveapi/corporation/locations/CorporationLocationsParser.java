package com.beimin.eveapi.corporation.locations;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.locations.AbstractLocationsParser;

public class CorporationLocationsParser extends AbstractLocationsParser {
	public CorporationLocationsParser() {
		super(ApiPath.CORPORATION);
	}
}