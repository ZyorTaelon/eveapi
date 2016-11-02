package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.character.ChatChannelsHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.character.ChatChannelsResponse;

public class ChatChannelsParser extends AbstractApiParser<ChatChannelsResponse> {
    public ChatChannelsParser() {
        super(ChatChannelsResponse.class, 2, ApiPath.CHARACTER, ApiPage.CHAT_CHANNELS);
    }

    @Override
    protected AbstractContentHandler<ChatChannelsResponse> getContentHandler() {
        return new ChatChannelsHandler();
    }

    @Override
    public ChatChannelsResponse getResponse(ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
