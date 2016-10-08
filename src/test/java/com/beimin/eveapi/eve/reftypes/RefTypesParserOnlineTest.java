package com.beimin.eveapi.eve.reftypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.RefTypesParser;
import com.beimin.eveapi.response.eve.RefTypesResponse;

public class RefTypesParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final RefTypesParser parser = new RefTypesParser();
        final RefTypesResponse response = parser.getResponse();
        testResponse(response, 1);
    }

    @Test
    public void testEnum() throws Exception {
        final Map<Integer, com.beimin.eveapi.model.eve.RefType> map = new HashMap<Integer, com.beimin.eveapi.model.eve.RefType>();
        final RefTypesResponse response = new com.beimin.eveapi.parser.eve.RefTypesParser().getResponse();
        for (final com.beimin.eveapi.model.eve.RefType apiRefType : response.getAll()) {
            map.put(apiRefType.getRefTypeID(), apiRefType);
            final com.beimin.eveapi.model.shared.RefType refType = com.beimin.eveapi.model.shared.RefType.forID(apiRefType.getRefTypeID());
            assertNotNull("RefType missing - ID: " + apiRefType.getRefTypeID() + " (" + apiRefType.getRefTypeName() + ")", refType);
            assertEquals("RefType ID: " + refType.getId() + " wrong name", apiRefType.getRefTypeName(), refType.getName());
        }
        for (final com.beimin.eveapi.model.shared.RefType refType : com.beimin.eveapi.model.shared.RefType.values()) {
            assertNotNull(refType.name() + " no longer in the API", map.get(refType.getId()));
        }
        testFail("Test Enum is outside normal ways to do it");
    }

}
