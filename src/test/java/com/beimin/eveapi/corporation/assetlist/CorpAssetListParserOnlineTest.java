package com.beimin.eveapi.corporation.assetlist;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpAssetListParser;
import com.beimin.eveapi.response.shared.AssetListResponse;
import static org.junit.Assume.assumeTrue;

public class CorpAssetListParserOnlineTest extends AbstractOnlineTest {
    private final CorpAssetListParser classToTest = new CorpAssetListParser();

    @Before
    public void prepare() {
        setUp();
        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final AssetListResponse response = classToTest.getResponse(getCorp());

        testResponse(response);
    }

    @Test
    public void getResponseFlat() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final AssetListResponse response = classToTest.getResponse(getCorp(), true);

        testResponse(response);
    }

}
