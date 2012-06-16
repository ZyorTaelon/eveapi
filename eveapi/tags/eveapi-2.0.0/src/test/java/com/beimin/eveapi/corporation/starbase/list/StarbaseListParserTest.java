package com.beimin.eveapi.corporation.starbase.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.xml.sax.SAXException;

public class StarbaseListParserTest {

	@Test
	public void starbaseList() throws IOException, SAXException {
		StarbaseListParser parser = StarbaseListParser.getInstance();
		InputStream input = StarbaseListParserTest.class.getResourceAsStream("/corporation/StarbasesList.xml");
		StarbaseListResponse response = parser.getResponse(input);
		assertNotNull("Should have returned a result.", response);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2008, 1, 3, 1, 5, 55);
		Date currentTime = calendar.getTime();
		assertEquals(currentTime.toString(), response.getCurrentTime().toString());
		calendar.set(2008, 1, 3, 7, 5, 55);
		Date cachedUntil = calendar.getTime();
		assertEquals(cachedUntil.toString(), response.getCachedUntil().toString());
		Collection<ApiStarbase> starbases = response.getStarbases();
		assertNotNull("Should have returned a collection with starbases.", starbases);
		assertEquals("Should have returned 2 starbases.", 2, starbases.size());
		ApiStarbase starbase1 = starbases.iterator().next();
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