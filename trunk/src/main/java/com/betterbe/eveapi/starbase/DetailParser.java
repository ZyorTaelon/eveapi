package com.betterbe.eveapi.starbase;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.betterbe.eveapi.AbstractApiParser;

public class DetailParser extends AbstractApiParser {

	private Digester getDigester() {
		Digester digester = super.getDigester(DetailResponse.class);
		digester.addBeanPropertySetter("eveapi/result/generalSettings/usageFlags");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/deployFlags");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/allowCorporationMembers");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/allowAllianceMembers");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/claimSovereignty");

		digester.addObjectCreate("eveapi/result/combatSettings/onStandingDrop", CombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onStandingDrop");
		digester.addSetNext("eveapi/result/combatSettings/onStandingDrop", "setOnStandingDrop");

		digester.addObjectCreate("eveapi/result/combatSettings/onStatusDrop", CombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onStatusDrop");
		digester.addSetNext("eveapi/result/combatSettings/onStatusDrop", "setOnStatusDrop");

		digester.addObjectCreate("eveapi/result/combatSettings/onAggression", CombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onAggression");
		digester.addSetNext("eveapi/result/combatSettings/onAggression", "setOnAggression");

		digester.addObjectCreate("eveapi/result/combatSettings/onCorporationWar", CombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onCorporationWar");
		digester.addSetNext("eveapi/result/combatSettings/onCorporationWar", "setOnCorporationWar");

		digester.addObjectCreate("eveapi/result/rowset/row", FuelLevel.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addFuelLevel");
		return digester;
	}

	public DetailResponse getDetail(int userID, int characterID, String apiKey, int itemID) throws IOException, SAXException {
		String url = "http://api.eve-online.com/corp/StarbaseDetail.xml.aspx";
		url += "?userID=" + userID;
		url += "&characterID=" + characterID;
		url += "&apiKey=" + URLEncoder.encode(apiKey, "UTF8");
		url += "&version=2";
		url += "&itemID=" + itemID;
		System.out.println(url);
		Digester digester = getDigester();
		DetailResponse response = (DetailResponse) digester.parse(url);
		return response;
	}

	public DetailResponse getDetail(InputStream input) throws IOException, SAXException {
		Digester digester = getDigester();
		DetailResponse response = (DetailResponse) digester.parse(input);
		return response;
	}

	public static DetailParser getInstance() {
		return new DetailParser();
	}
}
