package com.beimin.eveapi.corporation.containerlog;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.ContainerLogParser;
import com.beimin.eveapi.response.corporation.ContainerLogResponse;
import static org.junit.Assume.assumeTrue;

public class ContainerLogParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final ContainerLogParser parser = new ContainerLogParser();
        prepareParser(parser);

        final ContainerLogResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
