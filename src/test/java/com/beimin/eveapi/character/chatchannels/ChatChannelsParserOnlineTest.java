package com.beimin.eveapi.character.chatchannels;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.ChatChannelsParser;
import com.beimin.eveapi.response.pilot.ChatChannelsResponse;

public class ChatChannelsParserOnlineTest extends AbstractOnlineTest {
	
    @Test
    public void getResponse() throws Exception {
        setAlias(ChatChannelsResponse.class, "channels", "items");
    	allowEmpty("getMotd");
    	allowEmpty("getReason");
    	allowNull("getReason");
    	allowNull("getUntilWhen");
        final ChatChannelsParser parser = new ChatChannelsParser();
        prepareParser(parser);

        final ChatChannelsResponse response = parser.getResponse(getCharacter());
        
        System.out.println(response.getAll());

        testResponse(response);
    }

}
