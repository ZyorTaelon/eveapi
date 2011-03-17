package com.beimin.eveapi.shared.factwar.stats;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

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

	@Override
	public FacWarStatsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}