package com.beimin.eveapi.character.assetlist;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharAssetListParser;
import com.beimin.eveapi.response.shared.AssetListResponse;

public class CharAssetListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        addEmptyOK("getAssets"); // Not all assets have sup assets
        final CharAssetListParser parser = new CharAssetListParser();
        final AssetListResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

    @Test
    public void getResponseFlat() throws Exception {
        addEmptyOK("getAssets"); // Not all assets have sup assets
        final CharAssetListParser parser = new CharAssetListParser();
        final AssetListResponse response = parser.getResponse(getPilot(), true);
        testResponse(response);
    }

}
