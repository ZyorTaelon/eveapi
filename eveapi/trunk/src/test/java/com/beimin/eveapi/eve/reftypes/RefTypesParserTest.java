package com.beimin.eveapi.eve.reftypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.wallet.RefType;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class RefTypesParserTest extends NoAuthParserTest {
	public RefTypesParserTest() {
		super(ApiPath.EVE, ApiPage.REF_TYPES);
	}

	@Test
	public void getResponse() throws ApiException {
		RefTypesParser parser = RefTypesParser.getInstance();
		RefTypesResponse response = parser.getResponse();
		assertNotNull(response);
		Collection<ApiRefType> refTypes = response.getAll();
		assertEquals(141, refTypes.size());
		boolean found = false;
		for (ApiRefType refType : refTypes) {
			if (refType.getRefTypeID() == 10) {
				found = true;
				assertEquals("Player Donation", refType.getRefTypeName());
			}
		}
		assertTrue("test refType wasn't found.", found);
	}

	@Test
	public void testEnum() throws ApiException {
		RefTypesParser parser = RefTypesParser.getInstance();
		RefTypesResponse response = parser.getResponse();
		assertNotNull(response);
		Collection<ApiRefType> refTypes = response.getAll();
		for (ApiRefType apiRefType : refTypes) {
			RefType refType = RefType.forID(apiRefType.getRefTypeID());
			assertNotNull("RefType missing - ID: " + apiRefType.getRefTypeID() + " (" + apiRefType.getRefTypeName() + ")", refType);
			assertEquals("RefType ID: " + refType.getId() + " wrong name", apiRefType.getRefTypeName(), refType.getName());
		}
	}
}