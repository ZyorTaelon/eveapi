package com.beimin.eveapi.eve.reftypes;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.eve.RefTypesParser;
import com.beimin.eveapi.response.eve.RefTypesResponse;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RefTypesParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		RefTypesParser parser = new RefTypesParser();
		RefTypesResponse response = parser.getResponse();
		testResponse(response, 1);
	}

	@Test
	public void testEnum() throws Exception {
		Map<Integer, com.beimin.eveapi.model.eve.RefType> map = new HashMap<Integer, com.beimin.eveapi.model.eve.RefType>();
		RefTypesResponse response = new com.beimin.eveapi.parser.eve.RefTypesParser().getResponse();
		for (com.beimin.eveapi.model.eve.RefType apiRefType : response.getAll()) {
			map.put(apiRefType.getRefTypeID(), apiRefType);
			com.beimin.eveapi.model.shared.RefType refType = com.beimin.eveapi.model.shared.RefType.forID(apiRefType.getRefTypeID());
			assertNotNull("RefType missing - ID: " + apiRefType.getRefTypeID() + " (" + apiRefType.getRefTypeName() + ")", refType);
			assertEquals("RefType ID: " + refType.getId() + " wrong name", apiRefType.getRefTypeName(), refType.getName());
		}
		for (com.beimin.eveapi.model.shared.RefType refType : com.beimin.eveapi.model.shared.RefType.values()) {
			assertNotNull(refType.name() + " no longer in the API", map.get(refType.getId()));
		}
		testFail("Test Enum is outside normal ways to do it");
	}

}