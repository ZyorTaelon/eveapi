package com.beimin.eveapi.map.factwar.systems;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.map.FacWarSystemsParser;
import com.beimin.eveapi.response.map.FacWarSystemsResponse;

public class FacWarSystemsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(FacWarSystemsResponse.class, "solarsystems", "items");
        allowEmpty("getOccupyingFactionID"); //not occupied
        allowEmpty("getOccupyingFactionName"); //not occupied
        allowEmpty("getVictoryPoints"); //not being captured
        final FacWarSystemsParser parser = new FacWarSystemsParser();
        prepareParser(parser);

        final FacWarSystemsResponse response = parser.getResponse();

        testResponse(response);
    }

}
