package com.beimin.eveapi.corporation.marketorders;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.MarketOrder;
import com.beimin.eveapi.parser.corporation.CorpMarketOrdersParser;
import com.beimin.eveapi.response.shared.MarketOrdersResponse;
import java.util.Set;

public class CorpMarketOrdersParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(MarketOrdersResponse.class, "orders", "items");
        final CorpMarketOrdersParser parser = new CorpMarketOrdersParser();
        prepareParser(parser);

        MarketOrdersResponse response = parser.getResponse(getCorp());
        testResponse(response);

        Set<MarketOrder> marketOrders = response.getAll();
        test(marketOrders);
        final MarketOrder marketOrder = marketOrders.iterator().next();
        response = parser.getResponse(getCharacter(), marketOrder.getOrderID());
        testResponse(response);
    }

}
