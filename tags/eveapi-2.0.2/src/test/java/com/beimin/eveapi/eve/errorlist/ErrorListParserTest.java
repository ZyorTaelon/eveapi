package com.beimin.eveapi.eve.errorlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ErrorListParserTest {

	@Test
	public void errorListParser() throws IOException, SAXException {
		ErrorListParser parser = ErrorListParser.getInstance();
		InputStream input = ErrorListParserTest.class.getResourceAsStream("/eve/ErrorList.xml");
		ErrorListResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiErrorListItem> errorListItems = response.getApiErrorListItems();
		assertEquals(61, errorListItems.size());
		boolean found = false;
		for (ApiErrorListItem apiErrorListItem : errorListItems) {
			if (apiErrorListItem.getErrorCode() == 110) {
				found = true;
				assertEquals("Invalid beforeTransID provided.", apiErrorListItem.getErrorText());
			}
		}
		assertTrue("test apiErrorListItem wasn't found.", found);
	}
}