package com.beimin.eveapi.eve.alliancelist;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.Alliance;
import com.beimin.eveapi.model.eve.MemberCorporation;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.AllianceListParser;
import com.beimin.eveapi.response.eve.AllianceListResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class AllianceListParserTest extends NoAuthParserTest {
    public AllianceListParserTest() {
        super(ApiPath.EVE, ApiPage.ALLIANCE_LIST);
    }

    @Test
    public void getResponse() throws ApiException {
        final AllianceListParser parser = new AllianceListParser();
        final AllianceListResponse response = parser.getResponse();
        assertNotNull(response);
        final Collection<Alliance> alliances = response.getAll();
        assertEquals(605, alliances.size());
        boolean found = false;
        for (final Alliance alliance : alliances) {
            if (alliance.getAllianceID() == 824518128) {
                found = true;
                assertEquals("GoonSwarm", alliance.getName());
                assertEquals("OHGOD", alliance.getShortName());
                assertEquals(749147334, alliance.getExecutorCorpID());
                assertEquals(5925, alliance.getMemberCount());
                assertDate(2006, 6, 3, 0, 50, 0, alliance.getStartDate());

                final Collection<MemberCorporation> memberCorporations = alliance.getMemberCorporations();
                assertEquals(69, memberCorporations.size());
                boolean corpFound = false;
                for (final MemberCorporation memberCorporation : memberCorporations) {
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
