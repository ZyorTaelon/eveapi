package com.beimin.eveapi.eve.factwar.stats;


import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class EveFacWarStatsParser extends AbstractApiParser<EveFacWarStats> {
	private EveFacWarStatsParser() {
		super(EveFacWarStats.class, 2, ApiPath.EVE, ApiPage.FACT_WAR_STATS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/totals/killsYesterday");
		digester.addBeanPropertySetter("eveapi/result/totals/killsLastWeek");
		digester.addBeanPropertySetter("eveapi/result/totals/killsTotal");
		digester.addBeanPropertySetter("eveapi/result/totals/victoryPointsYesterday");
		digester.addBeanPropertySetter("eveapi/result/totals/victoryPointsLastWeek");
		digester.addBeanPropertySetter("eveapi/result/totals/victoryPointsTotal");

		digester.addFactoryCreate("eveapi/result/rowset/row", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				if (attributes.getValue("pilots") != null)
					return new ApiFactionStats();
				return new ApiFactionWar();
			}
		});
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addStat");

		return digester;
	}

	public static EveFacWarStatsParser getInstance() {
		return new EveFacWarStatsParser();
	}

	@Override
	public EveFacWarStats getResponse() throws ApiException {
		return super.getResponse();
	}
}