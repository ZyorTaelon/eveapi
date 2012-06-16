package com.beimin.eveapi.map.kills;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class KillsHandler extends AbstractContentListHandler<KillsResponse, ApiSystemKills> {
	public KillsHandler() {
		super(KillsResponse.class);
	}

	@Override
	protected ApiSystemKills getItem(Attributes attrs) {
		ApiSystemKills item = new ApiSystemKills();
		item.setSolarSystemID(getInt(attrs, "solarSystemID"));
		item.setShipKills(getInt(attrs, "shipKills"));
		item.setPodKills(getInt(attrs, "podKills"));
		item.setFactionKills(getInt(attrs, "factionKills"));
		return item;
	}
}