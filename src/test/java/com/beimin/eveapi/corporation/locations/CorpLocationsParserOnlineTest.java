package com.beimin.eveapi.corporation.locations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.parser.corporation.CorpAssetListParser;
import com.beimin.eveapi.parser.corporation.CorpLocationsParser;
import com.beimin.eveapi.response.shared.AssetListResponse;
import com.beimin.eveapi.response.shared.LocationsResponse;

public class CorpLocationsParserOnlineTest extends AbstractOnlineTest {

    private List<Long> getItemIDs() throws Exception {
        final CorpAssetListParser parser = new CorpAssetListParser();
        final AssetListResponse response = parser.getResponse(getCorp());
        testResponse(response);
        final List<Asset> assets = response.getAll();
        final Set<Long> itemIDs = new HashSet<Long>();
        deepAssets(assets, itemIDs);
        return new ArrayList<Long>(itemIDs);
    }

    private void deepAssets(final List<Asset> assets, final Set<Long> itemIDs) {
        for (final Asset asset : assets) {
            itemIDs.add(asset.getItemID());
            deepAssets(asset.getAssets(), itemIDs);
        }
    }

    @Test
    public void getResponse() throws Exception {
        final CorpLocationsParser parser = new CorpLocationsParser();
        final LocationsResponse response = parser.getResponse(getCorp(), getItemIDs());
        testResponse(response);
    }

}
