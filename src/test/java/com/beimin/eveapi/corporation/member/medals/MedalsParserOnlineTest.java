package com.beimin.eveapi.corporation.member.medals;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.MemberMedalsParser;
import com.beimin.eveapi.response.corporation.MemberMedalsResponse;
import static org.junit.Assume.assumeTrue;

public class MedalsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final MemberMedalsParser parser = new MemberMedalsParser();
        prepareParser(parser);

        final MemberMedalsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
