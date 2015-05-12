package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.eve.Alliance;
import com.beimin.eveapi.model.eve.MemberCorporation;
import com.beimin.eveapi.response.eve.AllianceListResponse;

public class AllianceListHandler extends AbstractContentListHandler<AllianceListResponse, Alliance> {
	private boolean memberCorporations;
	private Alliance alliance;

	public AllianceListHandler() {
		super(AllianceListResponse.class);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("rowset"))
			memberCorporations = getString(attrs, "name").equals("memberCorporations");
		else if (qName.equals("row")) {
			if (memberCorporations) {
				MemberCorporation memberCorporation = new MemberCorporation();
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
	protected Alliance getItem(Attributes attrs) {
		Alliance alliance = new Alliance();
		alliance.setAllianceID(getLong(attrs, "allianceID"));
		alliance.setName(getString(attrs, "name"));
		alliance.setShortName(getString(attrs, "shortName"));
		alliance.setExecutorCorpID(getLong(attrs, "executorCorpID"));
		alliance.setMemberCount(getInt(attrs, "memberCount"));
		alliance.setStartDate(getDate(attrs, "startDate"));
		return alliance;
	}
}