package com.beimin.eveapi.corporation.sheet;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpSheetParser;
import com.beimin.eveapi.response.corporation.CorpSheetResponse;
import static org.junit.Assume.assumeTrue;

public class CorpSheetParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("Other error", TestControl.runOther());
        // Not in alliance
        addNullOk("getAllianceName");
        addEmptyOK("getAllianceID");
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

        final CorpSheetResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
