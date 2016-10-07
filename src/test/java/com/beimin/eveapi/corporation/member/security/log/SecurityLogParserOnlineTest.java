package com.beimin.eveapi.corporation.member.security.log;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.MemberSecurityLogParser;
import com.beimin.eveapi.response.corporation.MemberSecurityLogResponse;

public class SecurityLogParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final MemberSecurityLogParser parser = new MemberSecurityLogParser();
        final MemberSecurityLogResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}