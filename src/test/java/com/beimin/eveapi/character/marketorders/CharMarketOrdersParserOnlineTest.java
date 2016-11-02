package com.beimin.eveapi.character.marketorders;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.MarketOrder;
import com.beimin.eveapi.parser.character.CharMarketOrdersParser;
import com.beimin.eveapi.response.shared.MarketOrdersResponse;

public class CharMarketOrdersParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(MarketOrdersResponse.class, "orders", "items");
        allowEmpty("getBid"); // zero is a valid value
        allowEmpty("getEscrow"); // zero is a valid value
        allowEmpty("getOrderState"); // zero is a valid value
        final CharMarketOrdersParser parser = new CharMarketOrdersParser();
        prepareParser(parser);

        MarketOrdersResponse response = parser.getResponse(getCharacter());

        testResponse(response);

        Set<MarketOrder> marketOrders = response.getAll();
        test(marketOrders);
        final MarketOrder marketOrder = marketOrders.iterator().next();
        response = parser.getResponse(getCharacter(), marketOrder.getOrderID());

        testResponse(response);
    }

}
