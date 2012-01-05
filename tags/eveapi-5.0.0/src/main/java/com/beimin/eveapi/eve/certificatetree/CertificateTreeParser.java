package com.beimin.eveapi.eve.certificatetree;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class CertificateTreeParser extends AbstractListParser<CertificateTreeHandler, CertificateTreeResponse, ApiCertificateCategory> {
	public CertificateTreeParser() {
		super(CertificateTreeResponse.class, 2, ApiPath.EVE, ApiPage.CERTIFICATE_TREE, CertificateTreeHandler.class);
	}

	public static CertificateTreeParser getInstance() {
		return new CertificateTreeParser();
	}

	@Override
	public CertificateTreeResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}