package com.beimin.eveapi.map.sovereignty;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class SovereigntyHandler extends AbstractContentListHandler<SovereigntyResponse, ApiSystemSovereignty> {
	public SovereigntyHandler() {
		super(SovereigntyResponse.class);
	}

	@Override
	protected ApiSystemSovereignty getItem(Attributes attrs) {
		ApiSystemSovereignty item = new ApiSystemSovereignty();
		item.setSolarSystemID(getInt(attrs, "solarSystemID"));
		item.setSolarSystemName(getString(attrs, "solarSystemName"));
		item.setCorporationID(getLong(attrs, "corporationID"));
		item.setAllianceID(getInt(attrs, "allianceID"));
		item.setFactionID(getInt(attrs, "factionID"));
		return item;
	}
}