package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.handler.shared.BlueprintsHandler;
import com.beimin.eveapi.model.shared.Blueprint;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.BlueprintsResponse;

public abstract class AbstractBlueprintsParser extends AbstractListParser<BlueprintsHandler, BlueprintsResponse, Blueprint> {
    protected AbstractBlueprintsParser(ApiPath path) {
        super(BlueprintsResponse.class, 2, path, ApiPage.BLUEPRINTS, BlueprintsHandler.class);
    }
}