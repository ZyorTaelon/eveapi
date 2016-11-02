package com.beimin.eveapi.character.mail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.character.MailMessage;
import com.beimin.eveapi.parser.character.MailMessagesParser;
import com.beimin.eveapi.response.character.MailMessagesResponse;

public class MailMessagesParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(MailMessagesResponse.class, "messages", "items");
        setAlias(MailMessage.class, "toListID", "toListIDs");
        allowNull("getCharacterIDs"); // not to character
        allowEmpty("getToCharacterIDs"); // not to character
        allowEmpty("getToListIDs"); // not to list
        allowNull("getListIDs"); // not to list
        allowNull("getToCorpOrAllianceID"); // not to corp or alliance

        final MailMessagesParser parser = new MailMessagesParser();
        prepareParser(parser);

        final MailMessagesResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
