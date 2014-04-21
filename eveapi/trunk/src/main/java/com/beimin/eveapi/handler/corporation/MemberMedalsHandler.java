package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.MemberMedal;
import com.beimin.eveapi.response.corporation.MemberMedalsResponse;

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