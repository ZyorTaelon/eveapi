package com.beimin.eveapi.eve.alliancelist;

import static com.beimin.eveapi.utils.Assert.assertDate;
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

public class AllianceListParserTest extends NoAuthParserTest {
	public AllianceListParserTest() {
		super(ApiPath.EVE, ApiPage.ALLIANCE_LIST);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		AllianceListParser parser = AllianceListParser.getInstance();
		AllianceListResponse response = parser.getResponse();
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
				assertDate(2006, 6, 3, 0, 50, 0, alliance.getStartDate());

				Collection<ApiMemberCorporation> memberCorporations = alliance.getMemberCorporations();
				assertEquals(69, memberCorporations.size());
				boolean corpFound = false;
				for (ApiMemberCorporation memberCorporation : memberCorporations) {
					if (memberCorporation.getCorporationID() == 109788662) {
						corpFound = true;
						assertDate(2007, 9, 9, 19, 12, 0, memberCorporation.getStartDate());
					}
				}
				assertTrue("test memberCorporation wasn't found.", corpFound);
			}
		}
		assertTrue("test alliance wasn't found.", found);
	}
}