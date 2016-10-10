package com.beimin.eveapi.corporation.member.security.log;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.MemberSecurityLogParser;
import com.beimin.eveapi.response.corporation.MemberSecurityLogResponse;
import org.junit.Ignore;

public class SecurityLogParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("cacheUntil is null")
    public void getResponse() throws Exception {
        final MemberSecurityLogParser parser = new MemberSecurityLogParser();
        final MemberSecurityLogResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
