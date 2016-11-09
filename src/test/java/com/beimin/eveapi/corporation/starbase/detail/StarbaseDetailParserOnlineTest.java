package com.beimin.eveapi.corporation.starbase.detail;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.corporation.Starbase;
import com.beimin.eveapi.parser.corporation.StarbaseDetailParser;
import com.beimin.eveapi.parser.corporation.StarbaseListParser;
import com.beimin.eveapi.response.corporation.StarbaseDetailResponse;
import com.beimin.eveapi.response.corporation.StarbaseListResponse;

public class StarbaseDetailParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final StarbaseListParser starbaseListParser = new StarbaseListParser();
        final StarbaseListResponse starbaseListResponse = starbaseListParser.getResponse(getCorp());
        final List<Starbase> starbases = starbaseListResponse.getAll();
        test(starbases);
        final StarbaseDetailParser parser = new StarbaseDetailParser();
        prepareParser(parser);
        for (final Starbase starbase : starbases) {
            final StarbaseDetailResponse response = parser.getResponse(getCorp(), starbase.getItemID());
            testResponse(response);
        }
    }

}
