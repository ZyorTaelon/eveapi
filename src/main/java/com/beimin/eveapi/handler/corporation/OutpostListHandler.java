package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.Outpost;
import com.beimin.eveapi.response.corporation.OutpostListResponse;

public class OutpostListHandler extends AbstractContentListHandler<OutpostListResponse, Outpost> {

	public OutpostListHandler() {
		super(OutpostListResponse.class);
	}

	@Override
	protected Outpost getItem(Attributes attrs) {
		Outpost item = new Outpost();
		item.setStationID(getInt(attrs, "stationID"));
		item.setOwnerID(getLong(attrs, "ownerID"));
		item.setStandingOwnerID(getLong(attrs, "standingOwnerID"));
		item.setStationName(getString(attrs, "stationName"));
		item.setSolarSystemID(getInt(attrs, "solarSystemID"));
		item.setStationTypeID(getInt(attrs, "stationTypeID"));
		item.setDockingCostPerShipVolume(getDouble(attrs, "dockingCostPerShipVolume"));
		item.setOfficeRentalCost(getDouble(attrs, "officeRentalCost"));
		item.setReprocessingEfficiency(getDouble(attrs, "reprocessingEfficiency"));
		item.setReprocessingStationTake(getDouble(attrs, "reprocessingStationTake"));
		return item;
	}
}