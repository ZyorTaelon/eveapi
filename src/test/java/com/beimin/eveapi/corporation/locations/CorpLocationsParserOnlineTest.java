package com.beimin.eveapi.corporation.locations;

import java.util.ArrayList;
import java.util.List;

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
        final List<Asset> assets = response.getAll();
        test(assets);
        final List<Long> itemIDs = new ArrayList<>();
        deepAssets(assets, itemIDs);
        return itemIDs;
    }

    private void deepAssets(final List<Asset> assets, final List<Long> itemIDs) {
        for (final Asset asset : assets) {
            itemIDs.add(asset.getItemID());
            deepAssets(asset.getAssets(), itemIDs);
        }
    }

    @Test
    public void getResponse() throws Exception {
        final CorpLocationsParser parser = new CorpLocationsParser();
        prepareParser(parser);

        final LocationsResponse response = parser.getResponse(getCorp(), getItemIDs());

        testResponse(response);
    }

}
