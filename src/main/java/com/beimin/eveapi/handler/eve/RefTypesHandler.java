package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.eve.RefType;
import com.beimin.eveapi.response.eve.RefTypesResponse;

public class RefTypesHandler extends AbstractContentListHandler<RefTypesResponse, RefType> {

	public RefTypesHandler() {
		super(RefTypesResponse.class);
	}

	@Override
	protected RefType getItem(Attributes attrs) {
		RefType item = new RefType();
		item.setRefTypeID(getInt(attrs, "refTypeID"));
		item.setRefTypeName(getString(attrs, "refTypeName"));
		return item;
	}
}