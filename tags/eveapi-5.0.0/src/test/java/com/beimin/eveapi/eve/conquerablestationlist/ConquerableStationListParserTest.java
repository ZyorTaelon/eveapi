package com.beimin.eveapi.eve.conquerablestationlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class ConquerableStationListParserTest extends NoAuthParserTest {
	public ConquerableStationListParserTest() {
		super(ApiPath.EVE, ApiPage.CONQUERABLE_STATION_LIST);
	}

	@Test
	public void getResponse() throws ApiException {
		ConquerableStationListParser parser = ConquerableStationListParser.getInstance();
		StationListResponse response = parser.getResponse();
		assertNotNull(response);
		Map<Integer, ApiStation> stations = response.getStations();
		assertEquals(242, stations.size());
		ApiStation hzfStation = stations.get(61000118);
		assertNotNull(hzfStation);
		assertEquals("HZF RAPTURE", hzfStation.getStationName());
		assertEquals(21646, hzfStation.getStationTypeID());
		assertEquals(30000482, hzfStation.getSolarSystemID());
		assertEquals(182784411, hzfStation.getCorporationID());
		assertEquals("DarkStar 1", hzfStation.getCorporationName());
	}
}