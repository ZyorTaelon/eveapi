package com.beimin.eveapi.parser.eve;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.eve.CertificateTreeHandler;
import com.beimin.eveapi.model.eve.CertificateCategory;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.eve.CertificateTreeResponse;

public class CertificateTreeParser extends AbstractListParser<CertificateTreeHandler, CertificateTreeResponse, CertificateCategory> {
	public CertificateTreeParser() {
		super(CertificateTreeResponse.class, 2, ApiPath.EVE, ApiPage.CERTIFICATE_TREE, CertificateTreeHandler.class);
	}

	@Override
	public CertificateTreeResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}