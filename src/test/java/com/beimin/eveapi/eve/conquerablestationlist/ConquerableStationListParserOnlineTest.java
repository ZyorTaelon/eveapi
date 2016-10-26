package com.beimin.eveapi.eve.conquerablestationlist;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.ConquerableStationListParser;
import com.beimin.eveapi.response.eve.StationListResponse;

public class ConquerableStationListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(StationListResponse.class, "outposts", "stations");
        final ConquerableStationListParser parser = new ConquerableStationListParser();
        prepareParser(parser);

        final StationListResponse response = parser.getResponse();

        testResponse(response);
    }

}
