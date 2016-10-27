package com.beimin.eveapi.corporation.standings;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpStandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;

public class CorpStandingsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        ignoreXmlField("corporationNPCStandings");
        setAlias(StandingsResponse.class, "agents", "agentStandings");
        setAlias(StandingsResponse.class, "NPCCorporations", "npcCorporationStandings");
        setAlias(StandingsResponse.class, "factions", "factionStandings");
        final CorpStandingsParser parser = new CorpStandingsParser();
        prepareParser(parser);

        final StandingsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
