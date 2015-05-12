package com.beimin.eveapi.character.locations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Location;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.LocationsParser;
import com.beimin.eveapi.parser.shared.AbstractLocationsParser;
import com.beimin.eveapi.response.shared.LocationsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class LocationsParserTest extends FullAuthParserTest {
	public LocationsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.LOCATIONS);
	}

	@Test
	public void getResponse() throws ApiException {
		AbstractLocationsParser parser = new LocationsParser();
		LocationsResponse response = parser.getResponse(auth, Arrays.asList(1002861698719L));
		assertNotNull(response);
		Collection<Location> locations = response.getAll();
		assertNotNull(locations);
		assertEquals(1, locations.size());
		Location location = locations.iterator().next();
		assertEquals(1002861698719L, location.getItemID());
		assertEquals("Caldari Control Tower Medium", location.getItemName());
		assertEquals(-896690626560.1, location.getX(), 0.0001);
		assertEquals(-163314032640.2, location.getY(), 0.0001);
		assertEquals(-1323431485440.3, location.getZ(), 0.0001);
	}
}