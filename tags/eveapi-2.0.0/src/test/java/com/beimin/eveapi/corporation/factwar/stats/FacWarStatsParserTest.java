package com.beimin.eveapi.corporation.factwar.stats;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.character.assetlist.AssetListParserTest;
import com.beimin.eveapi.character.facwar.stats.FacWarStatsParser;
import com.beimin.eveapi.shared.factwar.stats.FacWarStats;

public class FacWarStatsParserTest {

	@Test
	public void facWarStats() throws IOException, SAXException {
		FacWarStatsParser parser = FacWarStatsParser.getInstance();
		InputStream input = AssetListParserTest.class.getResourceAsStream("/corporation/FacWarStats.xml");
		FacWarStats facWarStats = parser.getResponse(input);
		assertEquals(500001, facWarStats.getFactionID());
		assertEquals("Caldari State", facWarStats.getFactionName());
		assertEquals("2008-06-10 22:10:00", facWarStats.getEnlisted());
		assertEquals(0, facWarStats.getKillsYesterday());
		assertEquals(0, facWarStats.getKillsLastWeek());
		assertEquals(0, facWarStats.getKillsTotal());
		assertEquals(0, facWarStats.getVictoryPointsYesterday());
		assertEquals(1144, facWarStats.getVictoryPointsLastWeek());
		assertEquals(0, facWarStats.getVictoryPointsTotal());
		assertEquals(6, facWarStats.getPilots());
	}
}