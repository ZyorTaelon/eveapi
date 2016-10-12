package com.beimin.eveapi.character.marketorders;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.model.shared.MarketOrder;
import com.beimin.eveapi.parser.pilot.CharMarketOrdersParser;
import com.beimin.eveapi.response.shared.MarketOrdersResponse;
import static org.junit.Assume.assumeTrue;

public class CharMarketOrdersParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final CharMarketOrdersParser parser = new CharMarketOrdersParser();
        prepareParser(parser);

        MarketOrdersResponse response = parser.getResponse(getCharacter());

        testResponse(response);

        final MarketOrder marketOrder = response.getAll().iterator().next();
        response = parser.getResponse(getCharacter(), marketOrder.getOrderID());

        testResponse(response);
    }

}
