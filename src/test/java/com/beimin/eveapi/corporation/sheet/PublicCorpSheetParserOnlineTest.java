package com.beimin.eveapi.corporation.sheet;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpSheetParser;
import com.beimin.eveapi.response.corporation.CorpSheetResponse;

public class PublicCorpSheetParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void corporationSheetParser() throws Exception {
        // Private not included
        ignoreClassField(CorpSheetResponse.class, "memberLimit");
        ignoreClassField(CorpSheetResponse.class, "divisions");
        ignoreClassField(CorpSheetResponse.class, "walletDivisions");
        ignoreXmlField("logo");
        allowNull("getWalletDivisions");
        allowNull("getDivisions");
        allowNull("getMemberLimit");
        // Not in alliance
        allowNull("getAllianceName");
        allowEmpty("getAllianceID");
        // Not in faction
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

        final CorpSheetResponse response = parser.getResponse(getCorpID());

        testResponse(response);
    }

}
