package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.Location;
import com.beimin.eveapi.response.shared.LocationsResponse;

public class LocationsHandler extends AbstractContentListHandler<LocationsResponse, Location> {

	public LocationsHandler() {
		super(LocationsResponse.class);
	}

	@Override
	protected Location getItem(Attributes attrs) {
		Location location = new Location();
		location.setItemID(getLong(attrs, "itemID"));
		location.setItemName(getString(attrs, "itemName"));
		location.setX(getDouble(attrs, "x"));
		location.setY(getDouble(attrs, "y"));
		location.setZ(getDouble(attrs, "z"));
		return location;
	}

}