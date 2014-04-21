package com.beimin.eveapi.eve.errorlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.corporation.ErrorListItem;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.ErrorListParser;
import com.beimin.eveapi.response.eve.ErrorListResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class ErrorListParserTest extends NoAuthParserTest {
	public ErrorListParserTest() {
		super(ApiPath.EVE, ApiPage.ERROR_LIST);
	}

	@Test
	public void getResponse() throws ApiException {
		ErrorListParser parser = new ErrorListParser();
		ErrorListResponse response = parser.getResponse();
		assertNotNull(response);
		Collection<ErrorListItem> errorListItems = response.getAll();
		assertEquals(61, errorListItems.size());
		boolean found = false;
		for (ErrorListItem apiErrorListItem : errorListItems) {
			if (apiErrorListItem.getErrorCode() == 110) {
				found = true;
				assertEquals("Invalid beforeTransID provided.", apiErrorListItem.getErrorText());
			}
		}
		assertTrue("test apiErrorListItem wasn't found.", found);
	}
}