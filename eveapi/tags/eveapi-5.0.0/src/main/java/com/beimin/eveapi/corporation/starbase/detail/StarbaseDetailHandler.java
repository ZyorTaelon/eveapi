package com.beimin.eveapi.corporation.starbase.detail;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;

public class StarbaseDetailHandler extends AbstractContentHandler {
	private StarbaseDetailResponse response;

	@Override
	public void startDocument() throws SAXException {
		response = new StarbaseDetailResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		 if (qName.equals("onStandingDrop")) {
			response.setOnStandingDrop(getCombatSetting(attrs));
		} else if (qName.equals("onStatusDrop")) {
			response.setOnStatusDrop(getCombatSetting(attrs));
		} else if (qName.equals("onAggression")) {
			response.setOnAggression(getCombatSetting(attrs));
		} else if (qName.equals("onCorporationWar")) {
			response.setOnCorporationWar(getCombatSetting(attrs));
		} else if (qName.equals("row")) {
			response.addFuelLevel(getInt(attrs, "typeID"), getInt(attrs, "quantity"));
		} else
			super.startElement(uri, localName, qName, attrs);
	}

	private ApiCombatSetting getCombatSetting(Attributes attrs) {
		ApiCombatSetting onStandingDrop = new ApiCombatSetting();
		Integer standing = getInt(attrs, "standing");
		if(standing != null)
			onStandingDrop.setStanding(standing);
		onStandingDrop.setEnabled(getBoolean(attrs, "enabled"));
		return onStandingDrop;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("usageFlags")) {
			response.setUsageFlags(getInt());
		} else if (qName.equals("deployFlags")) {
			response.setDeployFlags(getInt());
		} else if (qName.equals("allowCorporationMembers")) {
			response.setAllowCorporationMembers(getBoolean());
		} else if (qName.equals("allowAllianceMembers")) {
			response.setAllowAllianceMembers(getBoolean());
		} else if (qName.equals("claimSovereignty")) {
			response.setClaimSovereignty(getBoolean());
		} 
		
		super.endElement(uri, localName, qName);
	}

	@Override
	public StarbaseDetailResponse getResponse() {
		return response;
	}
}