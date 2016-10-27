package com.beimin.eveapi.corporation.assetlist;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.parser.corporation.CorpAssetListParser;
import com.beimin.eveapi.response.shared.AssetListResponse;

public class CorpAssetListParserOnlineTest extends AbstractOnlineTest {
    private final CorpAssetListParser classToTest = new CorpAssetListParser();

    @Before
    public void prepare() {
        setUp();
        allowEmpty("getRawQuantity"); //only return for blueprints
        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        setAlias(Asset.class, "contents", "assets");
        final AssetListResponse response = classToTest.getResponse(getCorp());

        testResponse(response);
    }

    @Test
    public void getResponseFlat() throws Exception {
        ignoreClassField(Asset.class, "assets"); //Flat list
        final AssetListResponse response = classToTest.getResponse(getCorp(), true);

        testResponse(response);
    }

}
