package com.beimin.eveapi.eve.certificatetree;

import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.eve.CertificateTreeParser;
import com.beimin.eveapi.response.eve.CertificateTreeResponse;


public class CertificateTreeParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		CertificateTreeParser parser = new CertificateTreeParser();
		CertificateTreeResponse response = parser.getResponse();
		testResponse(response);
	}

}