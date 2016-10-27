package com.beimin.eveapi.corporation.industryjobs;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpIndustryJobsParser;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;

public class CorpIndustryJobsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(IndustryJobsResponse.class, "jobs", "items");
        final CorpIndustryJobsParser parser = new CorpIndustryJobsParser();
        prepareParser(parser);

        final IndustryJobsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
