package com.beimin.eveapi.corporation.member.security;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.MemberSecurityParser;
import com.beimin.eveapi.response.corporation.MemberSecurityResponse;
import org.junit.Ignore;

public class SecurityParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("Some data missing")
    public void getResponse() throws Exception {
        final MemberSecurityParser parser = new MemberSecurityParser();
        final MemberSecurityResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
