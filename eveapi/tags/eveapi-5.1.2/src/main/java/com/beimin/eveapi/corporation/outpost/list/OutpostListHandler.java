package com.beimin.eveapi.corporation.outpost.list;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class OutpostListHandler extends AbstractContentListHandler<OutpostListResponse, ApiOutpost> {

	public OutpostListHandler() {
		super(OutpostListResponse.class);
	}

	@Override
	protected ApiOutpost getItem(Attributes attrs) {
		ApiOutpost item = new ApiOutpost();
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