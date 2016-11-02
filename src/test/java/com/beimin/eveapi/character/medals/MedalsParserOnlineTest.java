package com.beimin.eveapi.character.medals;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.character.MedalsParser;
import com.beimin.eveapi.response.character.MedalsResponse;

public class MedalsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        ignoreClassField(MedalsResponse.class, "items");
        final MedalsParser parser = new MedalsParser();
        prepareParser(parser);

        final MedalsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
