package com.beimin.eveapi.character.blueprints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Blueprint;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.BlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class BlueprintsParserTest extends FullAuthParserTest {
    public BlueprintsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.BLUEPRINTS);
    }

    @Test
    public void blueprintsParser() throws ApiException {
        final BlueprintsParser parser = new BlueprintsParser();
        final BlueprintsResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final Set<Blueprint> blueprints = response.getAll();
        assertNotNull(blueprints);
        assertEquals(15, blueprints.size());
        boolean found = false;
        for (final Blueprint blueprint : blueprints) {
            if (blueprint.getItemID() == 231144695) {
                found = true;
                assertEquals(60014818L, blueprint.getLocationID());
                assertEquals(4, blueprint.getFlagID());
                assertEquals(10, blueprint.getMaterialEfficiency());
                assertEquals(-1, blueprint.getQuantity());
                assertEquals(-1, blueprint.getRuns());
                assertEquals(0, blueprint.getTimeEfficiency());
                assertEquals(1146, blueprint.getTypeID());
                assertEquals("Iron Charge L Blueprint", blueprint.getTypeName());
            }
        }
        assertTrue("test Blueprints wasn't found.", found);
    }
}
