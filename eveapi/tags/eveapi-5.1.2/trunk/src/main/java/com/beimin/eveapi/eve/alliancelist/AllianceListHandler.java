package com.beimin.eveapi.eve.alliancelist;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class AllianceListHandler extends AbstractContentListHandler<AllianceListResponse, ApiAlliance> {
	private boolean memberCorporations;
	private ApiAlliance alliance;

	public AllianceListHandler() {
		super(AllianceListResponse.class);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("rowset"))
			memberCorporations = getString(attrs, "name").equals("memberCorporations");
		else if (qName.equals("row")) {
			if (memberCorporations) {
				ApiMemberCorporation memberCorporation = new ApiMemberCorporation();
				memberCorporation.setCorporationID(getLong(attrs, "corporationID"));
				memberCorporation.setStartDate(getDate(attrs, "startDate"));
				alliance.add(memberCorporation);
			} else {
				alliance = getItem(attrs);
				response.add(alliance);
			}
		} else
			super.startElement(uri, localName, qName, attrs);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("rowset") && memberCorporations)
			memberCorporations = false;
		super.endElement(uri, localName, qName);
	}

	@Override
	protected ApiAlliance getItem(Attributes attrs) {
		ApiAlliance alliance = new ApiAlliance();
		alliance.setAllianceID(getLong(attrs, "allianceID"));
		alliance.setName(getString(attrs, "name"));
		alliance.setShortName(getString(attrs, "shortName"));
		alliance.setExecutorCorpID(getLong(attrs, "executorCorpID"));
		alliance.setMemberCount(getInt(attrs, "memberCount"));
		alliance.setStartDate(getDate(attrs, "startDate"));
		return alliance;
	}
}