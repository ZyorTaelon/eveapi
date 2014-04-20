package com.beimin.eveapi.corporation.outpost.servicedetail;

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
		super(ApiPath.CORPORATION, ApiPage.OUTPOST_SERVICE_DETAIL);
	}

	@Test
	public void getResponse() throws ApiException {
		OutpostServiceDetailParser parser = new OutpostServiceDetailParser();
		OutpostServiceDetailResponse response = parser.getResponse(auth);
		assertNotNull("Should have returned a result.", response);
		assertDate(2011, 4, 7, 19, 50, 25, response.getCurrentTime());
		assertDate(2011, 4, 7, 20, 47, 21, response.getCachedUntil());
		Collection<ApiOutpostServiceDetail> outposts = response.getAll();
		assertNotNull("Should have returned a collection with outpos.", outposts);
		assertEquals("Should have returned 4 outposs.", 4, outposts.size());
		ApiOutpostServiceDetail outpost = outposts.iterator().next();
		assertNotNull("Should have returned an outpost.", outpost);
		assertEquals(61000244, outpost.getStationID());
		assertEquals(773499566L, outpost.getOwnerID());
		assertEquals("Reprocessing Plant", outpost.getServiceName());
		assertEquals(2.0, outpost.getMinStanding(), 0.0005);
		assertEquals(10.0, outpost.getSurchargePerBadStanding(), 0.0005);
		assertEquals(0.0, outpost.getDiscountPerGoodStanding(), 0.0005);
	}
}