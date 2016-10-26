package com.beimin.eveapi.character.calendar;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.UpcomingCalendarEventsParser;
import com.beimin.eveapi.response.pilot.UpcomingCalendarEventsResponse;
import static org.junit.Assume.assumeTrue;

public class UpcomingCalendarEventsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        addEmptyOK("getOwnerTypeID");
        final UpcomingCalendarEventsParser parser = new UpcomingCalendarEventsParser();
        prepareParser(parser);
        
        final UpcomingCalendarEventsResponse response = parser.getResponse(getCharacter());
        
        testResponse(response);
    }

}
