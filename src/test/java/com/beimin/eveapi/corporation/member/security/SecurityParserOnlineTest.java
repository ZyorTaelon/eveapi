package com.beimin.eveapi.corporation.member.security;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.MemberSecurityParser;
import com.beimin.eveapi.response.corporation.MemberSecurityResponse;

public class SecurityParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        allowNull("getRoleDescription");
        final MemberSecurityParser parser = new MemberSecurityParser();
        prepareParser(parser);

        final MemberSecurityResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
