package com.beimin.eveapi.eve.factwar.stats;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;

public class FacWarStatsHandler extends AbstractContentHandler {
	private FacWarStatsResponse response;
	private boolean factions;
	private boolean factionWars;

	@Override
	public void startDocument() throws SAXException {
		response = new FacWarStatsResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("rowset")) {
			String name = getString(attrs, "name");
			factions = name.equals("factions");
			factionWars = name.equals("factionWars");
		} else if (qName.equals("row")) {
			if (factions) {
				ApiFactionStats item = new ApiFactionStats();
				item.setFactionID(getInt(attrs, "factionID"));
				item.setFactionName(getString(attrs, "factionName"));
				item.setPilots(getInt(attrs, "pilots"));
				item.setSystemsControlled(getInt(attrs, "systemsControlled"));
				item.setKillsYesterday(getInt(attrs, "killsYesterday"));
				item.setKillsLastWeek(getInt(attrs, "killsLastWeek"));
				item.setKillsTotal(getInt(attrs, "killsTotal"));
				item.setVictoryPointsYesterday(getInt(attrs, "victoryPointsYesterday"));
				item.setVictoryPointsLastWeek(getInt(attrs, "victoryPointsLastWeek"));
				item.setVictoryPointsTotal(getInt(attrs, "victoryPointsTotal"));
				response.addStat(item);
			} else if (factionWars) {
				ApiFactionWar item = new ApiFactionWar();
				item.setFactionID(getInt(attrs, "factionID"));
				item.setFactionName(getString(attrs, "factionName"));
				item.setAgainstID(getInt(attrs, "againstID"));
				item.setAgainstName(getString(attrs, "againstName"));
				response.addStat(item);
			}
		}
		super.startElement(uri, localName, qName, attrs);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("killsYesterday"))
			response.setKillsYesterday(getInt());
		else if (qName.equals("killsLastWeek"))
			response.setKillsLastWeek(getInt());
		else if (qName.equals("killsTotal"))
			response.setKillsTotal(getInt());
		else if (qName.equals("victoryPointsYesterday"))
			response.setVictoryPointsYesterday(getInt());
		else if (qName.equals("victoryPointsLastWeek"))
			response.setVictoryPointsLastWeek(getInt());
		else if (qName.equals("victoryPointsTotal"))
			response.setVictoryPointsTotal(getInt());
		else if (qName.equals("rowset")) {
			factions = false;
			factionWars = false;
		}
		super.endElement(uri, localName, qName);
	}

	// @Override
	// protected Digester getDigester() {
	// Digester digester = super.getDigester();
	// digester.addBeanPropertySetter("eveapi/result/totals/killsYesterday");
	// digester.addBeanPropertySetter("eveapi/result/totals/killsLastWeek");
	// digester.addBeanPropertySetter("eveapi/result/totals/killsTotal");
	// digester.addBeanPropertySetter("eveapi/result/totals/victoryPointsYesterday");
	// digester.addBeanPropertySetter("eveapi/result/totals/victoryPointsLastWeek");
	// digester.addBeanPropertySetter("eveapi/result/totals/victoryPointsTotal");
	//
	// digester.addFactoryCreate("eveapi/result/rowset/row", new AbstractObjectCreationFactory() {
	// @Override
	// public Object createObject(Attributes attributes) throws Exception {
	// if (attributes.getValue("pilots") != null)
	// return new ApiFactionStats();
	// return new ApiFactionWar();
	// }
	// });
	// digester.addSetProperties("eveapi/result/rowset/row");
	// digester.addSetNext("eveapi/result/rowset/row", "addStat");
	//
	// return digester;
	// }

	@Override
	public FacWarStatsResponse getResponse() {
		return response;
	}
}