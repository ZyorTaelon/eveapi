package com.beimin.eveapi.server;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.ServerStatusParser;
import com.beimin.eveapi.response.ServerStatusResponse;

public class ServerStatusParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final ServerStatusParser parser = new ServerStatusParser();
        final ServerStatusResponse response = parser.getServerStatus();
        testResponse(response);
    }

}