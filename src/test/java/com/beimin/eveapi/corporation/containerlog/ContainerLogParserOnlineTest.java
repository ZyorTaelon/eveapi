package com.beimin.eveapi.corporation.containerlog;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.ContainerLogParser;
import com.beimin.eveapi.response.corporation.ContainerLogResponse;
import org.junit.Ignore;

public class ContainerLogParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final ContainerLogParser parser = new ContainerLogParser();
        final ContainerLogResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
