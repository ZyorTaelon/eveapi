package com.beimin.eveapi.character.marketorders;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.MarketOrder;
import com.beimin.eveapi.parser.pilot.CharMarketOrdersParser;
import com.beimin.eveapi.response.shared.MarketOrdersResponse;

public class CharMarketOrdersParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final CharMarketOrdersParser parser = new CharMarketOrdersParser();
        MarketOrdersResponse response = parser.getResponse(getPilot());
        testResponse(response);

        final MarketOrder marketOrder = response.getAll().iterator().next();
        response = parser.getResponse(getPilot(), marketOrder.getOrderID());
        testResponse(response);
    }

}
