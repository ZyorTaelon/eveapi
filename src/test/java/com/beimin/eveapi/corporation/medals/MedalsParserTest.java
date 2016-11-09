package com.beimin.eveapi.corporation.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.corporation.Medal;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.MedalsParser;
import com.beimin.eveapi.response.corporation.MedalsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MedalsParserTest extends FullAuthParserTest {
    public MedalsParserTest() {
        super(ApiPath.CORPORATION, ApiPage.MEDALS);
    }

    @Test
    public void getResponse() throws ApiException {
        final MedalsParser parser = new MedalsParser();
        final MedalsResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final List<Medal> medals = response.getAll();
        assertEquals("Incorrect amount of members found.", 18, medals.size());
        final Medal medal = medals.iterator().next();
        assertEquals("Wrong medal characterID", 1745, medal.getMedalID());
        assertEquals("Wrong medal name", "Capital Red Eyed Award", medal.getTitle());
        assertEquals("Wrong medal description", "This award is given to captial pilots that not only fought on the front lines but stayed up way to late and past their 9pm bedtimes to kill the scum that think they are better than us.", medal.getDescription());
        assertEquals("Wrong member name", 817217271L, medal.getCreatorID());
        assertDate(2008, 11, 12, 7, 37, 0, medal.getCreated());
    }
}
