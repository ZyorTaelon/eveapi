package com.beimin.eveapi.eve.conquerablestationlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.Station;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.ConquerableStationListParser;
import com.beimin.eveapi.response.eve.StationListResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class ConquerableStationListParserTest extends NoAuthParserTest {
    public ConquerableStationListParserTest() {
        super(ApiPath.EVE, ApiPage.CONQUERABLE_STATION_LIST);
    }

    @Test
    public void getResponse() throws ApiException {
        final ConquerableStationListParser parser = new ConquerableStationListParser();
        final StationListResponse response = parser.getResponse();
        assertNotNull(response);
        final Map<Long, Station> stations = response.getStations();
        assertEquals(1208, stations.size());
        final Station station = stations.get(61001046L);

        assertNotNull(station);
        assertEquals(61001046, station.getStationID());
        assertEquals("W-XY4J X - Deadly Impasse", station.getStationName());
        assertEquals(21646, station.getStationTypeID());
        assertEquals(30001105, station.getSolarSystemID());
        assertEquals(98181032, station.getCorporationID());
        assertEquals("BOT EXECS", station.getCorporationName());
        assertEquals(394820444160L, station.getX());
        assertEquals(-18220769280L, station.getY());
        assertEquals(-6131542302720L, station.getZ());
    }
}

