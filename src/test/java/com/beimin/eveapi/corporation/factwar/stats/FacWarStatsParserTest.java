package com.beimin.eveapi.corporation.factwar.stats;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.FacWarStatsParser;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class FacWarStatsParserTest extends FullAuthParserTest {
	public FacWarStatsParserTest() {
		super(ApiPath.CORPORATION, ApiPage.FACT_WAR_STATS);
	}

	@Test
	public void getResponse() throws ApiException {
		FacWarStatsParser parser = new FacWarStatsParser();
		FacWarStatsResponse facWarStats = parser.getResponse(auth);
		assertEquals(500001, facWarStats.getFactionID());
		assertEquals("Caldari State", facWarStats.getFactionName());
		assertDate(2008, 6, 10, 22, 10, 0, facWarStats.getEnlisted());
		assertEquals(0, facWarStats.getKillsYesterday());
		assertEquals(0, facWarStats.getKillsLastWeek());
		assertEquals(0, facWarStats.getKillsTotal());
		assertEquals(0, facWarStats.getVictoryPointsYesterday());
		assertEquals(1144, facWarStats.getVictoryPointsLastWeek());
		assertEquals(0, facWarStats.getVictoryPointsTotal());
		assertEquals(6, facWarStats.getPilots());
	}
}