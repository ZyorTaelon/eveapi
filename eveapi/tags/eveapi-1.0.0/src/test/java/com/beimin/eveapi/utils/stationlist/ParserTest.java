package com.beimin.eveapi.utils.stationlist;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {

	@Test
	public void testConquerableStationListParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/ConquerableStationList.xml");
		Response response = parser.getResponse(input);
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
		assertTrue("Todo: ", true);
	}
}