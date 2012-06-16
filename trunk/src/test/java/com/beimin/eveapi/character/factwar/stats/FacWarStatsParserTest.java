package com.beimin.eveapi.character.factwar.stats;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;


import org.junit.Test;


import com.beimin.eveapi.character.facwar.stats.FacWarStatsParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.facwar.stats.FacWarStatsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class FacWarStatsParserTest extends FullAuthParserTest {
	public FacWarStatsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.FACT_WAR_STATS);
	}

	@Test
	public void getResponse() throws ApiException {
		FacWarStatsParser parser = FacWarStatsParser.getInstance();
		FacWarStatsResponse facWarStats = parser.getResponse(auth);
		assertEquals(500001, facWarStats.getFactionID());
		assertEquals("Caldari State", facWarStats.getFactionName());
		assertDate(2008, 6, 10, 22, 10, 0, facWarStats.getEnlisted());
		assertEquals(4, facWarStats.getCurrentRank());
		assertEquals(4, facWarStats.getHighestRank());
		assertEquals(0, facWarStats.getKillsYesterday());
		assertEquals(0, facWarStats.getKillsLastWeek());
		assertEquals(0, facWarStats.getKillsTotal());
		assertEquals(0, facWarStats.getVictoryPointsYesterday());
		assertEquals(1044, facWarStats.getVictoryPointsLastWeek());
		assertEquals(0, facWarStats.getVictoryPointsTotal());
	}
}