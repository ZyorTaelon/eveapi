package com.beimin.eveapi.eve.factwar.stats.top;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class FacWarTopStatsParser extends AbstractApiParser<FacWarTopStatsResponse> {
	private static final String FACT_WAR_TOP_STATS_URL = "/eve/FacWarTopStats";

	private FacWarTopStatsParser() {
		super(FacWarTopStatsResponse.class, 2, FACT_WAR_TOP_STATS_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/characters", CharacterStats.class);
		digester.addObjectCreate("eveapi/result/characters/rowset", StatsList.class);
		digester.addSetProperties("eveapi/result/characters/rowset");
		digester.addFactoryCreate(	"eveapi/result/characters/rowset/row", 	new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				if (attributes.getValue("kills") != null)
					return new CharacterKills();
				else if (attributes.getValue("victoryPoints") != null)
					return new CharacterVictoryPoints();
				return null;
			}
		});
		digester.addSetProperties("eveapi/result/characters/rowset/row");
		digester.addSetNext("eveapi/result/characters/rowset/row", "add");
		digester.addSetNext("eveapi/result/characters/rowset", "addStatsList");
		digester.addSetNext("eveapi/result/characters", "setCharacterStats");

		digester.addObjectCreate("eveapi/result/corporations", CorporationStats.class);
		digester.addObjectCreate("eveapi/result/corporations/rowset", StatsList.class);
		digester.addSetProperties("eveapi/result/corporations/rowset");
		digester.addFactoryCreate(	"eveapi/result/corporations/rowset/row", 	new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				if (attributes.getValue("kills") != null)
					return new CorporationKills();
				else if (attributes.getValue("victoryPoints") != null)
					return new CorporationVictoryPoints();
				return null;
			}
		});
		digester.addSetProperties("eveapi/result/corporations/rowset/row");
		digester.addSetNext("eveapi/result/corporations/rowset/row", "add");
		digester.addSetNext("eveapi/result/corporations/rowset", "addStatsList");
		digester.addSetNext("eveapi/result/corporations", "setCorporationStats");

		digester.addObjectCreate("eveapi/result/factions", FactionStats.class);
		digester.addObjectCreate("eveapi/result/factions/rowset", StatsList.class);
		digester.addSetProperties("eveapi/result/factions/rowset");
		digester.addFactoryCreate(	"eveapi/result/factions/rowset/row", 	new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				if (attributes.getValue("kills") != null)
					return new FactionKills();
				else if (attributes.getValue("victoryPoints") != null)
					return new FactionVictoryPoints();
				return null;
			}
		});
		digester.addSetProperties("eveapi/result/factions/rowset/row");
		digester.addSetNext("eveapi/result/factions/rowset/row", "add");
		digester.addSetNext("eveapi/result/factions/rowset", "addStatsList");
		digester.addSetNext("eveapi/result/factions", "setFactionStats");
		return digester;
	}

	public FacWarTopStatsResponse getFacWarStats() throws IOException, SAXException {
		return getResponse();
	}

	public static FacWarTopStatsParser getInstance() {
		return new FacWarTopStatsParser();
	}
}