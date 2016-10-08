package com.beimin.eveapi.account.apikeyinfo;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.account.ApiKeyInfoParser;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;

public class ApiKeyInfoParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        addEmptyOK("getAllianceName"); // Maybe you're not in an alliance
        addNullOk("getExpires"); // Never Expires
        addEmptyOK("getFactionName"); // Not member of faction
        addEmptyOK("getFactionID"); // Not member of faction
        final ApiKeyInfoParser apiKeyInfoParser = new ApiKeyInfoParser();
        final ApiKeyInfoResponse response = apiKeyInfoParser.getResponse(getAccount());
        testResponse(response);
    }

}
