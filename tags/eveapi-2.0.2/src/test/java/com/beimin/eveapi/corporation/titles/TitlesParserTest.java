package com.beimin.eveapi.corporation.titles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

public class TitlesParserTest {

	@Test
	public void testTitlesParser() throws IOException, SAXException, ParseException {
		CorporationTitlesParser parser = CorporationTitlesParser.getInstance();
		InputStream input = TitlesParserTest.class.getResourceAsStream("/corporation/Titles.xml");
		CorporationTitlesResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiTitle> titles = response.getTitles();
		assertEquals(2, titles.size());
		boolean found = false;
		for (ApiTitle title : titles) {
			if (title.getTitleID() == 1) {
				found = true;
				assertEquals("Member", title.getTitleName());
				Collection<ApiRole> rolesAtHQ = title.getRolesAtHQ();
				assertEquals(1, rolesAtHQ.size());
				ApiRole role = rolesAtHQ.iterator().next();
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