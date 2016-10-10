package com.beimin.eveapi.api.calllist;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.calllist.CallListParser;
import com.beimin.eveapi.response.calllist.CallListResponse;

public class CallListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final CallListParser parser = new CallListParser();
        prepareParser(parser);

        final CallListResponse response = parser.getResponse();

        testResponse(response);
    }

}
