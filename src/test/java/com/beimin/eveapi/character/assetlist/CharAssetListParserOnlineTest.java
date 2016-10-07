package com.beimin.eveapi.character.assetlist;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.PilotAssetListParser;
import com.beimin.eveapi.parser.shared.AbstractAssetListParser;
import com.beimin.eveapi.response.shared.AssetListResponse;

public class CharAssetListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        addEmptyOK("getAssets"); // Not all assets have sup assetsgetAssets
        final AbstractAssetListParser parser = new PilotAssetListParser();
        final AssetListResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

    @Test
    public void getResponseFlat() throws Exception {
        addEmptyOK("getAssets"); // Not all assets have sup assetsgetAssets
        final AbstractAssetListParser parser = new PilotAssetListParser();
        final AssetListResponse response = parser.getResponse(getPilot(), true);
        testResponse(response);
    }

}