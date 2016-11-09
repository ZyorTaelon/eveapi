package com.beimin.eveapi.handler.map;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.map.SystemJumps;
import com.beimin.eveapi.response.map.JumpsResponse;

public class JumpsHandler extends AbstractContentListHandler<JumpsResponse, SystemJumps> {
    public JumpsHandler() {
        super(new JumpsResponse());
    }

    @Override
    protected SystemJumps getItem(final Attributes attrs) {
        final SystemJumps item = new SystemJumps();
        saveAttributes(SystemJumps.class, attrs);
        item.setSolarSystemID(getInt(attrs, "solarSystemID"));
        item.setShipJumps(getInt(attrs, "shipJumps"));
        return item;
    }
}
