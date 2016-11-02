package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.character.CharacterSheetHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.character.CharacterSheetResponse;

public class CharacterSheetParser extends AbstractApiParser<CharacterSheetResponse> {
    public CharacterSheetParser() {
        super(CharacterSheetResponse.class, 1, ApiPath.CHARACTER, ApiPage.CHARACTER_SHEET);
    }

    @Override
    protected AbstractContentHandler<CharacterSheetResponse> getContentHandler() {
        return new CharacterSheetHandler();
    }

    @Override
    public CharacterSheetResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
