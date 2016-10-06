package com.beimin.eveapi.handler.shared;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.Blueprint;
import com.beimin.eveapi.response.shared.BlueprintsResponse;
import org.xml.sax.Attributes;

public class BlueprintsHandler extends AbstractContentListHandler<BlueprintsResponse, Blueprint> {

    public BlueprintsHandler() {
        super(BlueprintsResponse.class);
    }

    @Override
    protected Blueprint getItem(Attributes attrs) {
        Blueprint blueprint = new Blueprint();
        blueprint.setItemID(getLong(attrs, "itemID"));
        blueprint.setLocationID(getLong(attrs, "locationID"));
        blueprint.setTypeID(getInt(attrs, "typeID"));
        blueprint.setTypeName(getString(attrs, "typeName"));
        blueprint.setFlagID(getInt(attrs, "flagID"));
        blueprint.setQuantity(getInt(attrs, "quantity"));
        blueprint.setTimeEfficiency(getInt(attrs, "timeEfficiency"));
        blueprint.setMaterialEfficiency(getInt(attrs, "materialEfficiency"));
        blueprint.setRuns(getInt(attrs, "runs"));
        return blueprint;
    }
}