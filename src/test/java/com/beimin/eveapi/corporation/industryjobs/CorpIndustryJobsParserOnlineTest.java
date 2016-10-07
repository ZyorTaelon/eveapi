package com.beimin.eveapi.corporation.industryjobs;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.IndustryJobsParser;
import com.beimin.eveapi.parser.shared.AbstractIndustryJobsParser;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;

public class CorpIndustryJobsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final AbstractIndustryJobsParser parser = new IndustryJobsParser();
        final IndustryJobsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}