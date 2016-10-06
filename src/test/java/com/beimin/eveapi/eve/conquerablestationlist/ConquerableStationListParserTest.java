package com.beimin.eveapi.eve.conquerablestationlist;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.Station;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.ConquerableStationListParser;
import com.beimin.eveapi.response.eve.StationListResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConquerableStationListParserTest extends NoAuthParserTest {
    public ConquerableStationListParserTest() {
        super(ApiPath.EVE, ApiPage.CONQUERABLE_STATION_LIST);
    }

    @Test
    public void getResponse() throws ApiException {
        ConquerableStationListParser parser = new ConquerableStationListParser();
        StationListResponse response = parser.getResponse();
        assertNotNull(response);
        Map<Long, Station> stations = response.getStations();
        assertEquals(242, stations.size());
        Station hzfStation = stations.get(61000118l);
        assertNotNull(hzfStation);
        assertEquals("HZF RAPTURE", hzfStation.getStationName());
        assertEquals(21646, hzfStation.getStationTypeID());
        assertEquals(30000482, hzfStation.getSolarSystemID());
        assertEquals(182784411, hzfStation.getCorporationID());
        assertEquals("DarkStar 1", hzfStation.getCorporationName());
    }
}