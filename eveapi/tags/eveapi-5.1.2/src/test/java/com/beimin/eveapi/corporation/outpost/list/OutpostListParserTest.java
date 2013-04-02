package com.beimin.eveapi.corporation.outpost.list;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class OutpostListParserTest extends FullAuthParserTest {
	public OutpostListParserTest() {
		super(ApiPath.CORPORATION, ApiPage.OUTPOST_LIST);
	}

	@Test
	public void getResponse() throws ApiException {
		OutpostListParser parser = OutpostListParser.getInstance();
		OutpostListResponse response = parser.getResponse(auth);
		assertNotNull("Should have returned a result.", response);
		assertDate(2011, 4, 7, 19, 46, 15, response.getCurrentTime());
		assertDate(2011, 4, 7, 20, 43, 12, response.getCachedUntil());
		Collection<ApiOutpost> outposts = response.getAll();
		assertNotNull("Should have returned a collection with outpos.", outposts);
		assertEquals("Should have returned 3 outposs.", 3, outposts.size());
		ApiOutpost outpost = outposts.iterator().next();
		assertNotNull("Should have returned an outpost.", outpost);
		assertEquals(61000230, outpost.getStationID());
		assertEquals(773499566L, outpost.getOwnerID());
		assertEquals("F-G7BO VIII - FG Graduate Hall", outpost.getStationName());
		assertEquals(30000897, outpost.getSolarSystemID());
		assertEquals(0.0, outpost.getDockingCostPerShipVolume(), 0.0005);
		assertEquals(1.0, outpost.getOfficeRentalCost(), 0.0005);
		assertEquals(21644, outpost.getStationTypeID());
		assertEquals(0.5, outpost.getReprocessingEfficiency(), 0.0005);
		assertEquals(0.025, outpost.getReprocessingStationTake(), 0.0005);
		assertEquals(773499566L, outpost.getStandingOwnerID());
	}
}