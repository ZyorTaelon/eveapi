package com.beimin.eveapi.corporation.contacts;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpContactListParser;
import com.beimin.eveapi.response.corporation.ContactListResponse;

public class CorpContactListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        ignoreClassField(ContactListResponse.class, "contactList");
        ignoreClassField(ContactListResponse.class, "contactLabels");
        final CorpContactListParser parser = new CorpContactListParser();
        prepareParser(parser);

        final ContactListResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
