package com.beimin.eveapi.shared.locations;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class LocationsHandler extends AbstractContentListHandler<LocationsResponse, ApiLocation> {

	public LocationsHandler() {
		super(LocationsResponse.class);
	}

	@Override
	protected ApiLocation getItem(Attributes attrs) {
		ApiLocation location = new ApiLocation();
		location.setItemID(getLong(attrs, "itemID"));
		location.setItemName(getString(attrs, "itemName"));
		location.setX(getLong(attrs, "x"));
		location.setY(getLong(attrs, "y"));
		location.setZ(getLong(attrs, "z"));
		return location;
	}

}