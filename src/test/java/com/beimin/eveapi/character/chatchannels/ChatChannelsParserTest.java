package com.beimin.eveapi.character.chatchannels;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.character.ChatChannel;
import com.beimin.eveapi.model.character.ChatChannelAccessor;
import com.beimin.eveapi.model.character.ChatChannelExtendedAccessor;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.ChatChannelsParser;
import com.beimin.eveapi.response.character.ChatChannelsResponse;
import com.beimin.eveapi.utils.DateUtils;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ChatChannelsParserTest extends FullAuthParserTest {
    public ChatChannelsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.CHAT_CHANNELS);
    }

    @Test
    public void getResponse() throws ApiException {
        ChatChannelsParser parser = new ChatChannelsParser();

        ChatChannelsResponse response = parser.getResponse(auth);

        assertThat(response, notNullValue());
        List<ChatChannel> all = response.getAll();

        assertThat(all.size(), greaterThan(0));

        ChatChannel channel = all.iterator().next();

        assertThat(channel.getChannelID(), equalTo(-69329950l));
        assertThat(channel.getDisplayName(), equalTo("Players' Haven"));
        assertThat(channel.getMotd(), equalTo("<b>Feed pineapples to the cats!</b>"));
        assertThat(channel.getOwnerID(), equalTo(95578451l));
        assertThat(channel.getOwnerName(), equalTo("CCP Tellus"));
        assertThat(channel.isHasPassword(), equalTo(false));

        List<ChatChannelAccessor> allowedAccessors = channel.getAllowedAccessors();
        assertThat(allowedAccessors.size(), equalTo(1));
        ChatChannelAccessor allowed = allowedAccessors.get(0);
        assertThat(allowed.getAccessorID(), equalTo(99005629l));
        assertThat(allowed.getAccessorName(), equalTo("Tellus Alliance"));

        List<ChatChannelExtendedAccessor> blockedAccessors = channel.getBlockedAccessors();
        assertThat(blockedAccessors.size(), equalTo(1));
        ChatChannelExtendedAccessor blocked = blockedAccessors.get(0);
        assertThat(blocked.getAccessorName(), equalTo("Tellus Corporation"));
        assertThat(blocked.getUntilWhen(), equalTo(DateUtils.getGMTConverter().convert(Date.class, "0001-01-01 00:00:00")));

        List<ChatChannelExtendedAccessor> mutedAccessors = channel.getMutedAccessors();
        assertThat(mutedAccessors.size(), equalTo(1));
        ChatChannelExtendedAccessor muted = mutedAccessors.get(0);
        assertThat(muted.getUntilWhen(), equalTo(DateUtils.getGMTConverter().convert(Date.class, "2015-08-07 15:17:40")));
        assertThat(muted.getReason(), equalTo("Test success! You can't speak now."));

        List<ChatChannelAccessor> operatorAccessors = channel.getOperatorAccessors();
        assertThat(operatorAccessors.size(), equalTo(2));
        assertThat(operatorAccessors.get(0).getAccessorName(), equalTo("CCP FoxFour"));
        assertThat(operatorAccessors.get(1).getAccessorName(), equalTo("CCP Bartender"));
    }
}
