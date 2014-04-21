package com.beimin.eveapi.handler.map;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.map.SystemJumps;
import com.beimin.eveapi.response.map.JumpsResponse;

public class JumpsHandler extends AbstractContentListHandler<JumpsResponse, SystemJumps> {
	public JumpsHandler() {
		super(JumpsResponse.class);
	}

	@Override
	protected SystemJumps getItem(Attributes attrs) {
		SystemJumps item = new SystemJumps();
		item.setSolarSystemID(getInt(attrs, "solarSystemID"));
		item.setShipJumps(getInt(attrs, "shipJumps"));
		return item;
	}
}