package com.beimin.eveapi.character.standings;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharStandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;

public class CharStandingsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        ignoreXmlField("characterNPCStandings");
        setAlias(StandingsResponse.class, "agents", "agentStandings");
        setAlias(StandingsResponse.class, "NPCCorporations", "npcCorporationStandings");
        setAlias(StandingsResponse.class, "factions", "factionStandings");
        final CharStandingsParser parser = new CharStandingsParser();
        prepareParser(parser);

        final StandingsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
