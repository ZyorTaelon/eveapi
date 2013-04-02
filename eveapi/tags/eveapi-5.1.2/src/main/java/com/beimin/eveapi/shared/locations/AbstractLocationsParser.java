package com.beimin.eveapi.shared.locations;

import java.util.Iterator;
import java.util.List;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public abstract class AbstractLocationsParser extends AbstractListParser<LocationsHandler, LocationsResponse, ApiLocation> {
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