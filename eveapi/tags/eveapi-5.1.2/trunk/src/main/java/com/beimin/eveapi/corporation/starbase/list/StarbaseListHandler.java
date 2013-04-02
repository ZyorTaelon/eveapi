package com.beimin.eveapi.corporation.starbase.list;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class StarbaseListHandler extends AbstractContentListHandler<StarbaseListResponse, ApiStarbase> {

	public StarbaseListHandler() {
		super(StarbaseListResponse.class);
	}

	@Override
	protected ApiStarbase getItem(Attributes attrs) {
		ApiStarbase item = new ApiStarbase();
		item.setItemID(getLong(attrs, "itemID"));
		item.setTypeID(getInt(attrs, "typeID"));
		item.setLocationID(getInt(attrs, "locationID"));
		item.setMoonID(getInt(attrs, "moonID"));
		item.setState(getInt(attrs, "state"));
		item.setStateTimestamp(getDate(attrs, "stateTimestamp"));
		item.setOnlineTimestamp(getDate(attrs, "onlineTimestamp"));
		return item;
	}
}