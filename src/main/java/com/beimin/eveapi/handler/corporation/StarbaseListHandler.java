package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.Starbase;
import com.beimin.eveapi.response.corporation.StarbaseListResponse;

public class StarbaseListHandler extends AbstractContentListHandler<StarbaseListResponse, Starbase> {

    public StarbaseListHandler() {
        super(new StarbaseListResponse());
    }

    @Override
    protected Starbase getItem(final Attributes attrs) {
        final Starbase item = new Starbase();
        saveAttributes(Starbase.class, attrs);
        item.setItemID(getLong(attrs, "itemID"));
        item.setTypeID(getInt(attrs, "typeID"));
        item.setLocationID(getInt(attrs, "locationID"));
        item.setMoonID(getInt(attrs, "moonID"));
        item.setState(getInt(attrs, "state"));
        item.setStateTimestamp(getDate(attrs, "stateTimestamp"));
        item.setOnlineTimestamp(getDate(attrs, "onlineTimestamp"));
        return item;
    }
}
