package com.beimin.eveapi.eve.certificatetree;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.CertificateTreeParser;
import com.beimin.eveapi.response.eve.CertificateTreeResponse;

public class CertificateTreeParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CertificateTreeParser parser = new CertificateTreeParser();
        prepareParser(parser);

        final CertificateTreeResponse response = parser.getResponse();

        testResponse(response);
    }

}
