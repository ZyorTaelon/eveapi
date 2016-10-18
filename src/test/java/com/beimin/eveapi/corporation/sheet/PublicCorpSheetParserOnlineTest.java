package com.beimin.eveapi.corporation.sheet;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpSheetParser;
import com.beimin.eveapi.response.corporation.CorpSheetResponse;
import static org.junit.Assume.assumeTrue;

public class PublicCorpSheetParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void corporationSheetParser() throws Exception {
        assumeTrue("Bug: have dead fields", TestControl.runBug());
        addElementMissingOK(CorpSheetResponse.class, 1); //memberLimit not included in public return
        addIgnoreElement("logo");
        addIgnoreElement("row");
        // Private not included
        addNullOk("getWalletDivisions");
        addNullOk("getDivisions");
        addNullOk("getMemberLimit");
        // Not in alliance
        addNullOk("getAllianceName");
        addEmptyOK("getAllianceID");
        // Not in faction
        addEmptyOK("getFactionID");
        // No Tax
        addEmptyOK("getTaxRate");
        // Valid zero
        addEmptyOK("getGraphicID");
        addEmptyOK("getColor1");
        addEmptyOK("getColor2");
        addEmptyOK("getColor3");
        final CorpSheetParser parser = new CorpSheetParser();
        prepareParser(parser);

        final CorpSheetResponse response = parser.getResponse(getCorpID());

        testResponse(response);
    }

}
