package com.beimin.eveapi.eve.reftypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class RefTypesParserTest extends NoAuthParserTest {
	public RefTypesParserTest() {
		super(ApiPath.EVE, ApiPage.REF_TYPES);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		RefTypesParser parser = RefTypesParser.getInstance();
		RefTypesResponse response = parser.getResponse();
		assertNotNull(response);
		Collection<ApiRefType> refTypes = response.getRefTypes();
		assertEquals(87, refTypes.size());
		boolean found = false;
		for (ApiRefType refType : refTypes) {
			if (refType.getRefTypeID() == 10) {
				found = true;
				assertEquals("Player Donation", refType.getRefTypeName());
			}
		}
		assertTrue("test refType wasn't found.", found);
	}
}