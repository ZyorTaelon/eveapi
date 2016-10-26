package com.beimin.eveapi.corporation.contacts;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpContactListParser;
import com.beimin.eveapi.response.corporation.ContactListResponse;
import static org.junit.Assume.assumeTrue;

public class CorpContactListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("Needs to be refactored to be tested", TestControl.runBug());
        final CorpContactListParser parser = new CorpContactListParser();
        prepareParser(parser);

        final ContactListResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
