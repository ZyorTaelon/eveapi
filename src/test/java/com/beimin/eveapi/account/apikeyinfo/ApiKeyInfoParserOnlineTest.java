package com.beimin.eveapi.account.apikeyinfo;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.account.ApiKeyInfoParser;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;

public class ApiKeyInfoParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(com.beimin.eveapi.model.account.Character.class, "characterName", "name");
        setAlias(ApiKeyInfoResponse.class, "characters", "eveCharacters");
        ignoreXmlField("key");
        // Not in alliance
        allowEmpty("getAllianceName");
        allowEmpty("getAllianceID");
        // Not in faction
        allowEmpty("getFactionName");
        allowEmpty("getFactionID");
        // Never Expires
        allowNull("getExpires");
        final ApiKeyInfoParser apiKeyInfoParser = new ApiKeyInfoParser();
        prepareParser(apiKeyInfoParser);

        final ApiKeyInfoResponse response = apiKeyInfoParser.getResponse(getAccount());

        testResponse(response);
    }

}
