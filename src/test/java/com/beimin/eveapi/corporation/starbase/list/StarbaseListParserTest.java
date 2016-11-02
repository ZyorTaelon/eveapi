package com.beimin.eveapi.corporation.starbase.list;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.corporation.Starbase;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.StarbaseListParser;
import com.beimin.eveapi.response.corporation.StarbaseListResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class StarbaseListParserTest extends FullAuthParserTest {
    public StarbaseListParserTest() {
        super(ApiPath.CORPORATION, ApiPage.STARBASE_LIST);
    }

    @Test
    public void getResponse() throws ApiException {
        final StarbaseListParser parser = new StarbaseListParser();
        final StarbaseListResponse response = parser.getResponse(auth);
        assertNotNull("Should have returned a result.", response);
        assertDate(2008, 2, 3, 1, 5, 55, response.getCurrentTime());
        assertDate(2008, 2, 3, 7, 5, 55, response.getCachedUntil());
        final Collection<Starbase> starbases = response.getAll();
        assertNotNull("Should have returned a collection with starbases.", starbases);
        assertEquals("Should have returned 2 starbases.", 2, starbases.size());
        final Starbase starbase1 = starbases.iterator().next();
        assertNotNull("Should have returned a starbase.", starbase1);
        assertTrue("Starbase id should be set.", starbase1.getItemID() > 0);
        assertTrue("Starbase type id should be set.", starbase1.getTypeID() > 0);
        assertTrue("Starbase moon id should be set.", starbase1.getMoonID() > 0);
        assertTrue("Starbase location id should be set.", starbase1.getLocationID() > 0);
        assertNotNull("Starbase should have a state.", starbase1.getStarbaseState());
        assertNotNull("Starbase should have an online date.", starbase1.getOnlineTimestamp());
        assertNotNull("Starbase should have an state date.", starbase1.getStateTimestamp());
    }
}
