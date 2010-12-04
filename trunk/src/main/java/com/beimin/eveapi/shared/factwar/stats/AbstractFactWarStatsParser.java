package com.beimin.eveapi.shared.factwar.stats;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class AbstractFactWarStatsParser extends AbstractApiParser<FacWarStatsResponse> {
	protected AbstractFactWarStatsParser(ApiPath path) {
		super(FacWarStatsResponse.class, 2, path, ApiPage.FACT_WAR_STATS);
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

	public FacWarStatsResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}