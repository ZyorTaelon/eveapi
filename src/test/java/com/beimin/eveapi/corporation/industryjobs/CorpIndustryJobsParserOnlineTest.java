package com.beimin.eveapi.corporation.industryjobs;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpIndustryJobsParser;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;
import org.junit.Ignore;

public class CorpIndustryJobsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CorpIndustryJobsParser parser = new CorpIndustryJobsParser();
        final IndustryJobsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
