package com.beimin.eveapi.corporation.assetlist;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpAssetListParser;
import com.beimin.eveapi.response.shared.AssetListResponse;

public class CorpAssetListParserOnlineTest extends AbstractOnlineTest {
    private CorpAssetListParser classToTest = new CorpAssetListParser();

    @Before
    public void prepare() {
        setUp();
        prepareParser(classToTest);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final AssetListResponse response = classToTest.getResponse(getCorp());

        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseFlat() throws Exception {
        final AssetListResponse response = classToTest.getResponse(getCorp(), true);

        testResponse(response);
    }

}
