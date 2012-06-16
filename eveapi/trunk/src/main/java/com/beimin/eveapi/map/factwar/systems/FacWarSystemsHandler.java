package com.beimin.eveapi.map.factwar.systems;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class FacWarSystemsHandler extends AbstractContentListHandler<FacWarSystemsResponse, ApiFacWarSystem> {
	public FacWarSystemsHandler() {
		super(FacWarSystemsResponse.class);
	}

	@Override
	protected ApiFacWarSystem getItem(Attributes attrs) {
		ApiFacWarSystem item = new ApiFacWarSystem();
		item.setSolarSystemID(getInt(attrs, "solarSystemID"));
		item.setSolarSystemName(getString(attrs, "solarSystemName"));
		item.setContested(getBoolean(attrs, "contested"));
		item.setOccupyingFactionID(getInt(attrs, "occupyingFactionID"));
		item.setOccupyingFactionName(getString(attrs, "occupyingFactionName"));
		return item;
	}
}