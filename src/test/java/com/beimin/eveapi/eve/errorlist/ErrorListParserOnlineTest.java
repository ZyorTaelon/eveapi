package com.beimin.eveapi.eve.errorlist;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.ErrorListParser;
import com.beimin.eveapi.response.eve.ErrorListResponse;

public class ErrorListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final ErrorListParser parser = new ErrorListParser();
        final ErrorListResponse response = parser.getResponse();
        testResponse(response);
    }

}
