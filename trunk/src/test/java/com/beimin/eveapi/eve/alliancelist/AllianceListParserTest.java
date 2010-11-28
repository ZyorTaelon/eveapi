package com.beimin.eveapi.eve.alliancelist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.TimeZone;

import org.junit.Test;
import org.xml.sax.SAXException;

public class AllianceListParserTest {

	@Test
	public void allianceListParser() throws IOException, SAXException,
			ParseException {
		AllianceListParser parser = AllianceListParser.getInstance();
		InputStream input = AllianceListParserTest.class
				.getResourceAsStream("/eve/AllianceList.xml");
		AllianceListResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiAlliance> alliances = response.getAlliances();
		assertEquals(605, alliances.size());
		boolean found = false;
		for (ApiAlliance alliance : alliances) {
			if (alliance.getAllianceID() == 824518128) {
				found = true;
				assertEquals("GoonSwarm", alliance.getName());
				assertEquals("OHGOD", alliance.getShortName());
				assertEquals(749147334, alliance.getExecutorCorpID());
				assertEquals(5925, alliance.getMemberCount());
				Calendar calendar = Calendar.getInstance(TimeZone
						.getTimeZone("GMT"));
				calendar.set(Calendar.YEAR, 2006);
				calendar.set(Calendar.MONTH, 5);
				calendar.set(Calendar.DAY_OF_MONTH, 3);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 50);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(), alliance.getStartDateTime());

				Collection<ApiMemberCorporation> memberCorporations = alliance
						.getMemberCorporations();
				assertEquals(69, memberCorporations.size());
				boolean corpFound = false;
				for (ApiMemberCorporation memberCorporation : memberCorporations) {
					if (memberCorporation.getCorporationID() == 109788662) {
						corpFound = true;
						calendar.set(Calendar.YEAR, 2007);
						calendar.set(Calendar.MONTH, 8);
						calendar.set(Calendar.DAY_OF_MONTH, 9);
						calendar.set(Calendar.HOUR_OF_DAY, 19);
						calendar.set(Calendar.MINUTE, 12);
						calendar.set(Calendar.SECOND, 0);
						calendar.set(Calendar.MILLISECOND, 0);
						assertEquals(calendar.getTime(),
								memberCorporation.getStartDateTime());
					}
				}
				assertTrue("test memberCorporation wasn't found.", corpFound);
			}
		}
		assertTrue("test alliance wasn't found.", found);
	}
}