package com.beimin.eveapi.character.mail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.MailMessagesParser;
import com.beimin.eveapi.response.pilot.MailMessagesResponse;
import static org.junit.Assume.assumeTrue;

public class MailMessagesParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("Other error", TestControl.runOther());
        final MailMessagesParser parser = new MailMessagesParser();
        prepareParser(parser);

        final MailMessagesResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
