package com.beimin.eveapi.character.assetlist;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.parser.pilot.CharAssetListParser;
import com.beimin.eveapi.response.shared.AssetListResponse;

public class CharAssetListParserOnlineTest extends AbstractOnlineTest {
    private final CharAssetListParser classToTest = new CharAssetListParser();

    @Before
    public void prepare() {
        allowEmpty("getAssets"); // Not all assets have sup assets
        allowEmpty("getRawQuantity"); // Only returned for blueprints
        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        setAlias(Asset.class, "contents", "assets");
        final AssetListResponse response = classToTest.getResponse(getCharacter());

        testResponse(response);
    }

    @Test
    public void getResponseFlat() throws Exception {
        ignoreClassField(Asset.class, "assets"); // Flat list
        final AssetListResponse response = classToTest.getResponse(getCharacter(), true);

        testResponse(response);
    }

}
