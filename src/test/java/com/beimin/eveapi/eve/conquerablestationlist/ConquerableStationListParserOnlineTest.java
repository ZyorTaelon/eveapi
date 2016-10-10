package com.beimin.eveapi.eve.conquerablestationlist;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.ConquerableStationListParser;
import com.beimin.eveapi.response.eve.StationListResponse;
import org.junit.Ignore;

public class ConquerableStationListParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("New fields test not working")
    public void getResponse() throws Exception {
        final ConquerableStationListParser parser = new ConquerableStationListParser();
        final StationListResponse response = parser.getResponse();
        testResponse(response);
    }

}
