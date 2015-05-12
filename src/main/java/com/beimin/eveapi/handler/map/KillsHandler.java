package com.beimin.eveapi.handler.map;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.map.SystemKills;
import com.beimin.eveapi.response.map.KillsResponse;

public class KillsHandler extends AbstractContentListHandler<KillsResponse, SystemKills> {
	public KillsHandler() {
		super(KillsResponse.class);
	}

	@Override
	protected SystemKills getItem(Attributes attrs) {
		SystemKills item = new SystemKills();
		item.setSolarSystemID(getInt(attrs, "solarSystemID"));
		item.setShipKills(getInt(attrs, "shipKills"));
		item.setPodKills(getInt(attrs, "podKills"));
		item.setFactionKills(getInt(attrs, "factionKills"));
		return item;
	}
}