package com.beimin.eveapi.parser.shared;

import java.util.Iterator;
import java.util.List;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.shared.LocationsHandler;
import com.beimin.eveapi.model.shared.Location;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.LocationsResponse;

public abstract class AbstractLocationsParser extends AbstractListParser<LocationsHandler, LocationsResponse, Location> {
	protected AbstractLocationsParser(ApiPath path) {
		super(LocationsResponse.class, 2, path, ApiPage.LOCATIONS, LocationsHandler.class);
	}

	public LocationsResponse getResponse(ApiAuth<?> auth, List<Long> itemIDs) throws ApiException {
		StringBuilder idList = new StringBuilder();
		for (Iterator<Long> iterator = itemIDs.iterator(); iterator.hasNext();) {
			idList.append((Long) iterator.next());
			if(iterator.hasNext())
				idList.append(",");
		}
		return super.getResponse(auth, "IDs", idList.toString());
	}
}