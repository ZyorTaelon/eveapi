package com.beimin.eveapi.starbase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.betterbe.eveapi.starbase.ListParser;
import com.betterbe.eveapi.starbase.ListResponse;
import com.betterbe.eveapi.starbase.Starbase;

public class ListParserTest {

	@Test
	public void getList() throws IOException, SAXException {
		ListParser parser = ListParser.getInstance();
		InputStream input = ListParserTest.class.getResourceAsStream("/StarbasesList.xml");
		ListResponse response = parser.getList(input);
		assertNotNull("Should have returned a result.", response);
		assertEquals("Sun Feb 03 01:05:55 CET 2008", response.getCurrentTime().toString());
		assertEquals("Sun Feb 03 07:05:55 CET 2008", response.getCachedUntil().toString());
		Collection<Starbase> starbases = response.getStarbases();
		assertNotNull("Should have returned a collection with starbases.", starbases);
		assertEquals("Should have returned 2 starbases.", 2, starbases.size());
		Starbase starbase1 = starbases.iterator().next();
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