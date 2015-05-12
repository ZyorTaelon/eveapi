package com.beimin.eveapi.eve.reftypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.RefType;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.RefTypesParser;
import com.beimin.eveapi.response.eve.RefTypesResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class RefTypesParserTest extends NoAuthParserTest {
	public RefTypesParserTest() {
		super(ApiPath.EVE, ApiPage.REF_TYPES);
	}

	@Test
	public void getResponse() throws ApiException {
		RefTypesParser parser = new RefTypesParser();
		RefTypesResponse response = parser.getResponse();
		assertNotNull(response);
		Collection<RefType> refTypes = response.getAll();
		assertEquals(141, refTypes.size());
		boolean found = false;
		for (RefType refType : refTypes) {
			if (refType.getRefTypeID() == 10) {
				found = true;
				assertEquals("Player Donation", refType.getRefTypeName());
			}
		}
		assertTrue("test refType wasn't found.", found);
	}

	@Test
	public void testEnum() throws ApiException {
		RefTypesParser parser = new RefTypesParser();
		RefTypesResponse response = parser.getResponse();
		assertNotNull(response);
		Collection<RefType> refTypes = response.getAll();
		for (RefType apiRefType : refTypes) {
			com.beimin.eveapi.model.shared.RefType refType = com.beimin.eveapi.model.shared.RefType.forID(apiRefType.getRefTypeID());
			assertNotNull("RefType missing - ID: " + apiRefType.getRefTypeID() + " (" + apiRefType.getRefTypeName() + ")", refType);
			assertEquals("RefType ID: " + refType.getId() + " wrong name", apiRefType.getRefTypeName(), refType.getName());
		}
	}
}