package com.beimin.eveapi.character.marketorders;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.MarketOrder;
import com.beimin.eveapi.parser.pilot.CharMarketOrdersParser;
import com.beimin.eveapi.response.shared.MarketOrdersResponse;

public class CharMarketOrdersParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CharMarketOrdersParser parser = new CharMarketOrdersParser();
        prepareParser(parser);

        MarketOrdersResponse response = parser.getResponse(getCharacter());

        testResponse(response);

        final MarketOrder marketOrder = response.getAll().iterator().next();
        response = parser.getResponse(getCharacter(), marketOrder.getOrderID());

        testResponse(response);
    }

}
