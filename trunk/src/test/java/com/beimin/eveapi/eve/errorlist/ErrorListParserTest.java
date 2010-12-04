package com.beimin.eveapi.eve.errorlist;

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

public class ErrorListParserTest extends NoAuthParserTest {
	public ErrorListParserTest() {
		super(ApiPath.EVE, ApiPage.ERROR_LIST);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		ErrorListParser parser = ErrorListParser.getInstance();
		ErrorListResponse response = parser.getResponse();
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