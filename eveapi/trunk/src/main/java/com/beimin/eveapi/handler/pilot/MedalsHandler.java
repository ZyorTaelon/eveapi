package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.Medal;
import com.beimin.eveapi.response.pilot.MedalsResponse;

public class MedalsHandler extends AbstractContentListHandler<MedalsResponse, Medal> {
	public MedalsHandler() {
		super(MedalsResponse.class);
	}

	@Override
	protected Medal getItem(Attributes attrs) {
		Medal medal = new Medal();
		medal.setMedalID(getInt(attrs, "medalID"));
		medal.setCorporationID(getLong(attrs, "corporationID"));
		medal.setDescription(getString(attrs, "description"));
		medal.setIssued(getDate(attrs, "issued"));
		medal.setIssuerID(getLong(attrs, "issuerID"));
		medal.setReason(getString(attrs, "reason"));
		medal.setStatus(getString(attrs, "status"));
		medal.setTitle(getString(attrs, "title"));
		return medal;
	}
}