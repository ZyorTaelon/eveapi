package com.beimin.eveapi.shared.factwar.stats;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class AbstractFactWarStatsParser extends AbstractApiParser<FacWarStats> {
	private static final String FACT_WAR_STATS_URL = "/FacWarStats.xml.aspx";
	private final Path path;

	protected AbstractFactWarStatsParser(Path path) {
		super(FacWarStats.class, 2, FACT_WAR_STATS_URL);
		this.path = path;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/factionID");
		digester.addBeanPropertySetter("eveapi/result/factionName");
		digester.addBeanPropertySetter("eveapi/result/enlisted");
		digester.addBeanPropertySetter("eveapi/result/currentRank");
		digester.addBeanPropertySetter("eveapi/result/highestRank");
		digester.addBeanPropertySetter("eveapi/result/killsYesterday");
		digester.addBeanPropertySetter("eveapi/result/killsLastWeek");
		digester.addBeanPropertySetter("eveapi/result/killsTotal");
		digester.addBeanPropertySetter("eveapi/result/victoryPointsYesterday");
		digester.addBeanPropertySetter("eveapi/result/victoryPointsLastWeek");
		digester.addBeanPropertySetter("eveapi/result/victoryPointsTotal");
		digester.addBeanPropertySetter("eveapi/result/pilots");
		return digester;
	}

	public FacWarStats getFacWarStats(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, path);
	}
}