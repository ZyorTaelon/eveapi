package com.beimin.eveapi.handler.map;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.map.FacWarSystem;
import com.beimin.eveapi.response.map.FacWarSystemsResponse;

public class FacWarSystemsHandler extends AbstractContentListHandler<FacWarSystemsResponse, FacWarSystem> {
	public FacWarSystemsHandler() {
		super(FacWarSystemsResponse.class);
	}

	@Override
	protected FacWarSystem getItem(Attributes attrs) {
		FacWarSystem item = new FacWarSystem();
		item.setSolarSystemID(getInt(attrs, "solarSystemID"));
		item.setSolarSystemName(getString(attrs, "solarSystemName"));
		item.setContested(getBoolean(attrs, "contested"));
		item.setOccupyingFactionID(getInt(attrs, "occupyingFactionID"));
		item.setOccupyingFactionName(getString(attrs, "occupyingFactionName"));
		return item;
	}
}