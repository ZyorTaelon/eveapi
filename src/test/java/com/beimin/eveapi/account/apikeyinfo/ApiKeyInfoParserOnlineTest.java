package com.beimin.eveapi.account.apikeyinfo;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.account.ApiKeyInfoParser;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;

public class ApiKeyInfoParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        // Not in alliance
        addEmptyOK("getAllianceName"); 
        addEmptyOK("getAllianceID");
        // Not in faction
        addEmptyOK("getFactionName"); 
        addEmptyOK("getFactionID");
        // Never Expires
        addNullOk("getExpires");
        final ApiKeyInfoParser apiKeyInfoParser = new ApiKeyInfoParser();
        prepareParser(apiKeyInfoParser);

        final ApiKeyInfoResponse response = apiKeyInfoParser.getResponse(getAccount());

        testResponse(response);
    }

}
