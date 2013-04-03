package com.beimin.eveapi.corporation.member.medals;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class MemberMedalsHandler extends AbstractContentListHandler<MemberMedalsResponse, MemberMedal> {

	public MemberMedalsHandler() {
		super(MemberMedalsResponse.class);
	}

	@Override
	protected MemberMedal getItem(Attributes attrs) {
		MemberMedal medal = new MemberMedal();
		medal.setMedalID(getInt(attrs, "medalID"));
		medal.setCharacterID(getLong(attrs, "characterID"));
		medal.setIssued(getDate(attrs, "issued"));
		medal.setIssuerID(getLong(attrs, "issuerID"));
		medal.setReason(getString(attrs, "reason"));
		medal.setStatus(getString(attrs, "status"));
		return medal;
	}
}