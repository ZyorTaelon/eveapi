package com.beimin.eveapi.character.chatchannels;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.character.ChatChannel;
import com.beimin.eveapi.parser.character.ChatChannelsParser;
import com.beimin.eveapi.response.character.ChatChannelsResponse;

public class ChatChannelsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(ChatChannelsResponse.class, "channels", "items");
        setAlias(ChatChannel.class, "allowed", "allowedAccessors");
        setAlias(ChatChannel.class, "blocked", "blockedAccessors");
        setAlias(ChatChannel.class, "muted", "mutedAccessors");
        setAlias(ChatChannel.class, "operators", "operatorAccessors");
        allowEmpty("getMotd");
        allowEmpty("getReason");
        allowNull("getReason");
        allowNull("getUntilWhen");
        final ChatChannelsParser parser = new ChatChannelsParser();
        prepareParser(parser);

        final ChatChannelsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
