package com.beimin.eveapi.map.jumps;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.map.JumpsParser;
import com.beimin.eveapi.response.map.JumpsResponse;

public class JumpsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(JumpsResponse.class, "solarSystems", "items");
        ignoreClassField(JumpsResponse.class, "systemJumps");
        ignoreXmlField("datatime");
        final JumpsParser parser = new JumpsParser();
        prepareParser(parser);

        final JumpsResponse response = parser.getResponse();

        testResponse(response);
    }

}
