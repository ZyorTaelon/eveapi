package com.beimin.eveapi.corporation.member.security.log;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.MemberSecurityLogParser;
import com.beimin.eveapi.response.corporation.MemberSecurityLogResponse;
import static org.junit.Assume.assumeTrue;

public class SecurityLogParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final MemberSecurityLogParser parser = new MemberSecurityLogParser();
        prepareParser(parser);

        final MemberSecurityLogResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
