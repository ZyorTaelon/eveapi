package com.beimin.eveapi.eve.conquerablestationlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class ConquerableStationListParserTest extends NoAuthParserTest {
	public ConquerableStationListParserTest() {
		super(ApiPath.EVE, ApiPage.CONQUERABLE_STATION_LIST);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		ConquerableStationListParser parser = ConquerableStationListParser.getInstance();
		StationListResponse response = parser.getResponse();
		assertNotNull(response);
		Map<Long, ApiStation> stations = response.getStations();
		assertEquals(242, stations.size());
		ApiStation hzfStation = stations.get(61000118l);
		assertNotNull(hzfStation);
		assertEquals("HZF RAPTURE", hzfStation.getStationName());
		assertEquals(21646, hzfStation.getStationTypeID());
		assertEquals(30000482, hzfStation.getSolarSystemID());
		assertEquals(182784411, hzfStation.getCorporationID());
		assertEquals("DarkStar 1", hzfStation.getCorporationName());
		assertTrue("Todo: ", true);
	}
}