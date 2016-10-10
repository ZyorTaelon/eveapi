package com.beimin.eveapi.corporation.contacts;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpContactListParser;
import com.beimin.eveapi.response.corporation.ContactListResponse;

public class CorpContactListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final CorpContactListParser parser = new CorpContactListParser();
        final ContactListResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
