package com.beimin.eveapi.eve.conquerablestationlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ConquerableStationListParserTest {

	@Test
	public void testConquerableStationListParser() throws IOException, SAXException {
		ConquerableStationListParser parser = ConquerableStationListParser.getInstance();
		InputStream input = ConquerableStationListParserTest.class.getResourceAsStream("/eve/ConquerableStationList.xml");
		StationListResponse response = parser.getResponse(input);
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