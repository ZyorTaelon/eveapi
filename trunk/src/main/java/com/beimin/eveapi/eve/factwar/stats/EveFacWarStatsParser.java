package com.beimin.eveapi.eve.factwar.stats;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class EveFacWarStatsParser extends AbstractApiParser<EveFacWarStats> {
	private static final String FACT_WAR_STATS_URL = "/eve/FacWarStats";

	private EveFacWarStatsParser() {
		super(EveFacWarStats.class, 2, FACT_WAR_STATS_URL);
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

	public EveFacWarStats getFacWarStats() throws IOException, SAXException {
		return getResponse();
	}

	public static EveFacWarStatsParser getInstance() {
		return new EveFacWarStatsParser();
	}
}