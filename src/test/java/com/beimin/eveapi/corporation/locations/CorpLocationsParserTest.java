package com.beimin.eveapi.corporation.locations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Location;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.CorpLocationsParser;
import com.beimin.eveapi.response.shared.LocationsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CorpLocationsParserTest extends FullAuthParserTest {
    public CorpLocationsParserTest() {
        super(ApiPath.CORPORATION, ApiPage.LOCATIONS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CorpLocationsParser parser = new CorpLocationsParser();
        final LocationsResponse response = parser.getResponse(auth, Arrays.asList(1002861698719L));
        assertNotNull(response);
        final Collection<Location> locations = response.getAll();
        assertNotNull(locations);
        assertEquals(1, locations.size());
        final Location location = locations.iterator().next();
        assertEquals(1002861698719L, location.getItemID());
        assertEquals("Caldari Control Tower Medium", location.getItemName());
        assertEquals(-896690626560.1, location.getX(), 00000.1);
        assertEquals(-163314032640.2, location.getY(), 00000.1);
        assertEquals(-1323431485440.3, location.getZ(), 00000.1);
    }
}
