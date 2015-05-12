package com.beimin.eveapi.corporation.titles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.corporation.Role;
import com.beimin.eveapi.model.corporation.Title;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.TitlesParser;
import com.beimin.eveapi.response.corporation.TitlesResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class TitlesParserTest extends FullAuthParserTest {
	public TitlesParserTest() {
		super(ApiPath.CORPORATION, ApiPage.TITLES);
	}

	@Test
	public void getResponse() throws ApiException {
		TitlesParser parser = new TitlesParser();
		TitlesResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Collection<Title> titles = response.getAll();
		assertEquals(2, titles.size());
		boolean found = false;
		for (Title title : titles) {
			if (title.getTitleID() == 1) {
				found = true;
				assertEquals("Member", title.getTitleName());
				Collection<Role> rolesAtHQ = title.getRolesAtHQ();
				assertEquals(1, rolesAtHQ.size());
				Role role = rolesAtHQ.iterator().next();
				assertNotNull(role);
				assertEquals(8192, role.getRoleID());
				assertEquals("roleHangarCanTake1", role.getRoleName());
				assertEquals("Can take items from this divisions hangar", role.getRoleDescription());

				assertEquals(0, title.getRoles().size());
				assertEquals(0, title.getGrantableRoles().size());
				assertEquals(0, title.getGrantableRolesAtHQ().size());
				assertEquals(0, title.getRolesAtBase().size());
				assertEquals(0, title.getGrantableRolesAtBase().size());
				assertEquals(0, title.getRolesAtOther().size());
				assertEquals(0, title.getGrantableRolesAtOther().size());
			}
		}
		assertTrue("test title wasn't found.", found);
	}
}