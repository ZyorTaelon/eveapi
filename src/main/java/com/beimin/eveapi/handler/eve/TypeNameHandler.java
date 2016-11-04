package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.eve.EveTypeName;
import com.beimin.eveapi.response.eve.TypeNameResponse;

public class TypeNameHandler extends AbstractContentListHandler<TypeNameResponse, EveTypeName> {

    public TypeNameHandler() {
        super(new TypeNameResponse());
    }

    @Override
    protected EveTypeName getItem(final Attributes attrs) {
        final EveTypeName lookup = new EveTypeName();
        saveAttributes(EveTypeName.class, attrs);
        lookup.setTypeID(getInt(attrs, "typeID"));
        lookup.setTypeName(getString(attrs, "typeName"));
        return lookup;
    }
}
