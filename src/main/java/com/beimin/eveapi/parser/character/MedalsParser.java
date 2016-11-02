package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.character.MedalsHandler;
import com.beimin.eveapi.model.character.Medal;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.character.MedalsResponse;

public class MedalsParser extends AbstractListParser<MedalsHandler, MedalsResponse, Medal> {
    public MedalsParser() {
        super(MedalsResponse.class, 2, ApiPath.CHARACTER, ApiPage.MEDALS, MedalsHandler.class);
    }

    @Override
    public MedalsResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
