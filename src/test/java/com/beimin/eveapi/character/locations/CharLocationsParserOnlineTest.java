package com.beimin.eveapi.character.locations;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.parser.pilot.LocationsParser;
import com.beimin.eveapi.parser.pilot.PilotAssetListParser;
import com.beimin.eveapi.parser.shared.AbstractAssetListParser;
import com.beimin.eveapi.parser.shared.AbstractLocationsParser;
import com.beimin.eveapi.response.shared.AssetListResponse;
import com.beimin.eveapi.response.shared.LocationsResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharLocationsParserOnlineTest extends AbstractOnlineTest {

	private List<Long> getItemIDs() throws Exception {
		AbstractAssetListParser parser = new PilotAssetListParser();
		AssetListResponse response = parser.getResponse(getPilot());
		testResponse(response);
		List<Asset> assets = response.getAll();
		Set<Long> itemIDs = new HashSet<Long>();
		deepAssets(assets, itemIDs);
		return new ArrayList<Long>(itemIDs);
	}

	private void deepAssets(List<Asset> assets, Set<Long> itemIDs) {
		for (Asset asset : assets) {
			itemIDs.add(asset.getItemID());
			deepAssets(asset.getAssets(), itemIDs);
		}
	}

	@Test
	public void getResponse() throws Exception {
		AbstractLocationsParser parser = new LocationsParser();
		LocationsResponse response = parser.getResponse(getPilot(), getItemIDs());
		testResponse(response);
	}

}
