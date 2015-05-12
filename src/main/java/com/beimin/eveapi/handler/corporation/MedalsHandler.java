package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.Medal;
import com.beimin.eveapi.response.corporation.MedalsResponse;

public class MedalsHandler extends AbstractContentListHandler<MedalsResponse, Medal> {
	public MedalsHandler() {
		super(MedalsResponse.class);
	}

	@Override
	protected Medal getItem(Attributes attrs) {
		Medal medal = new Medal();
		medal.setMedalID(getInt(attrs, "medalID"));
		medal.setDescription(getString(attrs, "description"));
		medal.setCreatorID(getLong(attrs, "creatorID"));
		medal.setCreated(getDate(attrs, "created"));
		medal.setTitle(getString(attrs, "title"));
		return medal;
	}
}