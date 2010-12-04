package com.beimin.eveapi.eve.factwar.stats;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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

	public EveFacWarStats getResponse() throws IOException, SAXException {
		return super.getResponse();
	}
}