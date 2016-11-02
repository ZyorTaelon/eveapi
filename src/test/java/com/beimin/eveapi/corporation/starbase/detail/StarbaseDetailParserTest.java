package com.beimin.eveapi.corporation.starbase.detail;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.corporation.CombatSetting;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.StarbaseDetailParser;
import com.beimin.eveapi.response.corporation.StarbaseDetailResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class StarbaseDetailParserTest extends FullAuthParserTest {
    public StarbaseDetailParserTest() {
        super(ApiPath.CORPORATION, ApiPage.STARBASE_DETAIL);
    }

    @Test
    public void getResponse() throws ApiException {
        final StarbaseDetailParser parser = new StarbaseDetailParser();
        final StarbaseDetailResponse response = parser.getResponse(auth, 123456789);
        assertNotNull("Should have returned a result.", response);
        assertDate(2008, 2, 3, 1, 54, 2, response.getCurrentTime());
        assertDate(2008, 2, 3, 7, 54, 2, response.getCachedUntil());
        assertEquals(3, response.getUsageFlags());
        assertEquals(0, response.getDeployFlags());
        assertTrue(response.isAllowCorporationMembers());
        assertFalse(response.isAllowAllianceMembers());
        assertTrue(response.isClaimSovereignty());
        final CombatSetting onStandingDrop = response.getOnStandingDrop();
        assertNotNull("Should have a CombatSetting for standing drop.", onStandingDrop);
        assertFalse(onStandingDrop.isEnabled());
        assertEquals(10, onStandingDrop.getStanding());
        final CombatSetting onStatusDrop = response.getOnStatusDrop();
        assertNotNull("Should have a CombatSetting for status drop.", onStatusDrop);
        assertFalse(onStatusDrop.isEnabled());
        assertEquals(0, onStatusDrop.getStanding());
        final CombatSetting onAggression = response.getOnAggression();
        assertNotNull("Should have a CombatSetting for aggression.", onAggression);
        assertFalse(onAggression.isEnabled());
        final CombatSetting onCorporationWar = response.getOnCorporationWar();
        assertNotNull("Should have a CombatSetting for war.", onCorporationWar);
        assertTrue(onCorporationWar.isEnabled());
        final Map<Integer, Integer> fuelMap = response.getFuelMap();
        assertNotNull("Should have a fuelMap.", fuelMap);
        assertEquals(423L, fuelMap.get(44).longValue());
        assertEquals(2542L, fuelMap.get(3683).longValue());
        assertEquals(850L, fuelMap.get(3689).longValue());
        assertEquals(850L, fuelMap.get(9832).longValue());
        assertEquals(423L, fuelMap.get(9848).longValue());
        assertEquals(10800L, fuelMap.get(16272).longValue());
        assertEquals(4878L, fuelMap.get(16273).longValue());
        assertEquals(35955L, fuelMap.get(16274).longValue());
        assertEquals(150L, fuelMap.get(16275).longValue());
    }

    @Override
    public void extraAsserts(final Map<String, String> req) {
        super.extraAsserts(req);
        assertEquals("123456789", req.get("itemID"));
    }
}
