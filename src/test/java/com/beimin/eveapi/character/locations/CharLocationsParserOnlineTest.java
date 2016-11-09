package com.beimin.eveapi.character.locations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.parser.character.CharAssetListParser;
import com.beimin.eveapi.parser.character.CharLocationsParser;
import com.beimin.eveapi.response.shared.AssetListResponse;
import com.beimin.eveapi.response.shared.LocationsResponse;

public class CharLocationsParserOnlineTest extends AbstractOnlineTest {

    private List<Long> getItemIDs() throws Exception {
        allowEmpty("getAssets"); // Not all assets have sup assets
        final CharAssetListParser parser = new CharAssetListParser();
        final AssetListResponse response = parser.getResponse(getCharacter());
        final List<Asset> assets = response.getAll();
        test(assets);
        final List<Long> itemIDs = new ArrayList<Long>();
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
        // Not everything have coordinates
        allowEmpty("getX");
        allowEmpty("getZ");
        allowEmpty("getY");
        final CharLocationsParser parser = new CharLocationsParser();
        prepareParser(parser);

        final LocationsResponse response = parser.getResponse(getCharacter(), getItemIDs());

        testResponse(response);
    }

}
