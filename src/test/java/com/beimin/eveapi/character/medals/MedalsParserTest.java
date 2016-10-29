package com.beimin.eveapi.character.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.pilot.Medal;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.MedalsParser;
import com.beimin.eveapi.response.pilot.MedalsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MedalsParserTest extends FullAuthParserTest {
    public MedalsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.MEDALS);
    }

    @Test
    public void getResponse() throws ApiException {
        final MedalsParser parser = new MedalsParser();
        final MedalsResponse response = parser.getResponse(auth);
        assertNotNull(response);

        //All
        final Set<Medal> allMedals = response.getAll();
        assertEquals("Incorrect amount of medals found.", 2, allMedals.size());

        //Current
        final Set<Medal> currentMedals = response.getCurrentCorporation();
        assertEquals("Incorrect amount of medals found.", 1, currentMedals.size());
        final Medal currentMedal = currentMedals.iterator().next();
        assertEquals("Wrong medalID", 38208, currentMedal.getMedalID());
        assertNull("Wrong medal title", currentMedal.getTitle());
        assertNull("Wrong medal description", currentMedal.getDescription());
        assertEquals("Wrong medal reason", "found the undock button", currentMedal.getReason());
        assertEquals("Wrong medal issuerID", 718955203L, currentMedal.getIssuerID());
        assertDate(2010, 02, 29, 2, 14, 33, currentMedal.getIssued());
        assertNull("Wrong medal corporationID", currentMedal.getCorporationID());
        assertFalse("Should be private", currentMedal.isPublic());

        //Other
        final Set<Medal> otherMedals = response.getOtherCorporations();
        assertEquals("Incorrect amount of medals found.", 1, otherMedals.size());
        final Medal otherMedal = otherMedals.iterator().next();
        assertEquals("Wrong medalID", 40125, otherMedal.getMedalID());
        assertEquals("Wrong medal title", "Christian Fundamentalist Award", otherMedal.getTitle());
        assertEquals("Wrong medal description", "For relentlessly trying to spread the Good Message. Even within an internet spaceship game.", otherMedal.getDescription());
        assertEquals("Wrong medal reason", "cuz hes awesome", otherMedal.getReason());
        assertEquals("Wrong medal issuerID", 753005810L, otherMedal.getIssuerID());
        assertDate(2009, 12, 23, 0, 32, 04, otherMedal.getIssued());
        assertEquals("Wrong medal corporationID", 182784411L, otherMedal.getCorporationID().longValue());
        assertTrue("Should be public", otherMedal.isPublic());
    }
}

