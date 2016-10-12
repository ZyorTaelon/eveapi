package com.beimin.eveapi.corporation.shareholders;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.ShareholdersParser;
import com.beimin.eveapi.response.corporation.ShareholdersResponse;
import static org.junit.Assume.assumeTrue;

public class ShareholdersParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("Other error", TestControl.runOther());
        final ShareholdersParser parser = new ShareholdersParser();
        prepareParser(parser);

        final ShareholdersResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
