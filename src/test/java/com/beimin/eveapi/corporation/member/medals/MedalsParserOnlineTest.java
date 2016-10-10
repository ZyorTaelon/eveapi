package com.beimin.eveapi.corporation.member.medals;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.MemberMedalsParser;
import com.beimin.eveapi.response.corporation.MemberMedalsResponse;
import org.junit.Ignore;

public class MedalsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final MemberMedalsParser parser = new MemberMedalsParser();
        final MemberMedalsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
