package com.beimin.eveapi.corporation.member.security;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.MemberSecurityParser;
import com.beimin.eveapi.response.corporation.MemberSecurityResponse;

public class SecurityParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("Some data missing")
    public void getResponse() throws Exception {
        final MemberSecurityParser parser = new MemberSecurityParser();
        prepareParser(parser);

        final MemberSecurityResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
