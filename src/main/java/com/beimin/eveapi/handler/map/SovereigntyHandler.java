package com.beimin.eveapi.handler.map;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.map.SystemSovereignty;
import com.beimin.eveapi.response.map.SovereigntyResponse;

public class SovereigntyHandler extends AbstractContentListHandler<SovereigntyResponse, SystemSovereignty> {
	public SovereigntyHandler() {
		super(SovereigntyResponse.class);
	}

	@Override
	protected SystemSovereignty getItem(Attributes attrs) {
		SystemSovereignty item = new SystemSovereignty();
		item.setSolarSystemID(getInt(attrs, "solarSystemID"));
		item.setSolarSystemName(getString(attrs, "solarSystemName"));
		item.setCorporationID(getLong(attrs, "corporationID"));
		item.setAllianceID(getInt(attrs, "allianceID"));
		item.setFactionID(getInt(attrs, "factionID"));
		return item;
	}
}