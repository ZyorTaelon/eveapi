package com.beimin.eveapi.corporation.sheet;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpSheetParser;
import com.beimin.eveapi.response.corporation.CorpSheetResponse;

public class CorpSheetParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        ignoreXmlField("logo");
        // Not in alliance
        allowNull("getAllianceName");
        allowEmpty("getAllianceID");
        allowEmpty("getFactionID");
        // No Tax
        allowEmpty("getTaxRate");
        // Valid zero
        allowEmpty("getGraphicID");
        allowEmpty("getColor1");
        allowEmpty("getColor2");
        allowEmpty("getColor3");
        final CorpSheetParser parser = new CorpSheetParser();
        prepareParser(parser);

        final CorpSheetResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
