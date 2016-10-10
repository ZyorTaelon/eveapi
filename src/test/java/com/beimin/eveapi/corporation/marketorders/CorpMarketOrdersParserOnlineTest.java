package com.beimin.eveapi.corporation.marketorders;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.MarketOrder;
import com.beimin.eveapi.parser.corporation.CorpMarketOrdersParser;
import com.beimin.eveapi.response.shared.MarketOrdersResponse;
import org.junit.Ignore;

public class CorpMarketOrdersParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CorpMarketOrdersParser parser = new CorpMarketOrdersParser();
        MarketOrdersResponse response = parser.getResponse(getCorp());
        testResponse(response);

        final MarketOrder marketOrder = response.getAll().iterator().next();
        response = parser.getResponse(getPilot(), marketOrder.getOrderID());
        testResponse(response);
    }

}
