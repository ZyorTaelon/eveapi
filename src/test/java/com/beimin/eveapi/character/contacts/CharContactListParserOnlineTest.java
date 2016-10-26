package com.beimin.eveapi.character.contacts;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.CharContactListParser;
import com.beimin.eveapi.response.pilot.ContactListResponse;
import static org.junit.Assume.assumeTrue;

public class CharContactListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        addEmptyOK("getLabelMask"); //zero is a valid value
        addEmptyOK("getStanding"); //zero is a valid value
        final CharContactListParser parser = new CharContactListParser();
        prepareParser(parser);

        final ContactListResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
