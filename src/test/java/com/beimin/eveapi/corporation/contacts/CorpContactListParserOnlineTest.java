package com.beimin.eveapi.corporation.contacts;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpContactListParser;
import com.beimin.eveapi.response.corporation.ContactListResponse;

public class CorpContactListParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("Some data missing")
    public void getResponse() throws Exception {
        final CorpContactListParser parser = new CorpContactListParser();
        prepareParser(parser);

        final ContactListResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
