package com.beimin.eveapi.corporation.contacts;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.ContactListParser;
import com.beimin.eveapi.response.corporation.ContactListResponse;

public class CorpContactListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final ContactListParser parser = new ContactListParser();
        final ContactListResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}