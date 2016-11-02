package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractBlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;

public class CharBlueprintsParser extends AbstractBlueprintsParser {
    public CharBlueprintsParser() {
        super(ApiPath.CHARACTER);
    }

    @Override
    public BlueprintsResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
