package com.beimin.eveapi.eve.typename;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class TypeNameHandler extends AbstractContentListHandler<TypeNameResponse, EveTypeName> {

	public TypeNameHandler() {
		super(TypeNameResponse.class);
	}

	@Override
	protected EveTypeName getItem(Attributes attrs) {
		EveTypeName lookup = new EveTypeName();
		lookup.setTypeID(getInt(attrs, "typeID"));
		lookup.setTypeName(getString(attrs, "typeName"));
		return lookup;
	}
}