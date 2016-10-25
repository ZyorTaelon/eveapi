package com.beimin.eveapi.character.assetlist;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharAssetListParser;
import com.beimin.eveapi.response.shared.AssetListResponse;

public class CharAssetListParserOnlineTest extends AbstractOnlineTest {
    private CharAssetListParser classToTest = new CharAssetListParser();

    @Before
    public void prepare() {
        super.before();
        addEmptyOK("getAssets"); // Not all assets have sup assets
        addEmptyOK("getRawQuantity"); //Only returned for blueprints
        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        final AssetListResponse response = classToTest.getResponse(getCharacter());

        testResponse(response);
    }

    @Test
    public void getResponseFlat() throws Exception {
        final AssetListResponse response = classToTest.getResponse(getCharacter(), true);

        testResponse(response);
    }

}
