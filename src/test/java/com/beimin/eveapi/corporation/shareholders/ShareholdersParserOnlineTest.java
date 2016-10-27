package com.beimin.eveapi.corporation.shareholders;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.corporation.Shareholder;
import com.beimin.eveapi.parser.corporation.ShareholdersParser;
import com.beimin.eveapi.response.corporation.ShareholdersResponse;

public class ShareholdersParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        ignoreClassField(ShareholdersResponse.class, "items");
         //No characters shareholders in test API Key
        ignoreClassField(Shareholder.class, "shareholderCorporationID");
        ignoreClassField(Shareholder.class, "shareholderCorporationName");
        allowNull("getShareholderCorporationName");
        allowNull("getShareholderCorporationID");
        final ShareholdersParser parser = new ShareholdersParser();
        prepareParser(parser);

        final ShareholdersResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
