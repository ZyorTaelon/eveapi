package com.beimin.eveapi.eve.typename;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.TypeNameParser;
import com.beimin.eveapi.response.eve.TypeNameResponse;

public class TypeNameParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final TypeNameParser parser = new TypeNameParser();
        prepareParser(parser);

        final TypeNameResponse response = parser.getResponse(getTypeID());

        testResponse(response);
    }

}
