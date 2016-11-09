package com.beimin.eveapi.character.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.character.Medal;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.MedalsParser;
import com.beimin.eveapi.response.character.MedalsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MedalsParserTest extends FullAuthParserTest {
    public MedalsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.MEDALS);
    }

    @Test
    public void getResponse() throws ApiException {
        final MedalsParser parser = new MedalsParser();
        final MedalsResponse response = parser.getResponse(auth);
        assertThat(response, notNullValue());

        // All
        final List<Medal> allMedals = response.getAll();
        assertThat("Incorrect amount of medals found.", allMedals.size(), equalTo(2));

        // Current
        final List<Medal> currentMedals = response.getCurrentCorporation();
        assertThat("Incorrect amount of medals found.", currentMedals.size(), equalTo(1));
        final Medal currentMedal = currentMedals.iterator().next();
        assertThat("Wrong medalID", currentMedal.getMedalID(), equalTo(38208));
        assertThat("Wrong medal title", currentMedal.getTitle(), nullValue());
        assertThat("Wrong medal description", currentMedal.getDescription(), nullValue());
        assertThat("Wrong medal reason", currentMedal.getReason(), equalTo("found the undock button"));
        assertThat("Wrong medal issuerID", currentMedal.getIssuerID(), equalTo(718955203L));
        assertDate(2010, 02, 29, 2, 14, 33, currentMedal.getIssued());
        assertThat("Wrong medal corporationID", currentMedal.getCorporationID(), nullValue());
        assertThat("Should be private", currentMedal.isPublic(), equalTo(false));

        // Other
        final List<Medal> otherMedals = response.getOtherCorporations();
        assertThat("Incorrect amount of medals found.", otherMedals.size(), equalTo(1));
        final Medal otherMedal = otherMedals.iterator().next();
        assertThat("Wrong medalID", otherMedal.getMedalID(), equalTo(40125));
        assertThat("Wrong medal title", otherMedal.getTitle(), equalTo("Christian Fundamentalist Award"));
        assertThat("Wrong medal description", otherMedal.getDescription(), equalTo("For relentlessly trying to spread the Good Message. Even within an internet spaceship game."));
        assertThat("Wrong medal reason", otherMedal.getReason(), equalTo("cuz hes awesome"));
        assertThat("Wrong medal issuerID", otherMedal.getIssuerID(), equalTo(753005810L));
        assertDate(2009, 12, 23, 0, 32, 04, otherMedal.getIssued());
        assertThat("Wrong medal corporationID", otherMedal.getCorporationID().longValue(), equalTo(182784411L));
        assertThat("Should be public", otherMedal.isPublic(), equalTo(true));
    }
}
