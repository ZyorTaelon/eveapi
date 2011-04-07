package com.beimin.eveapi.eve.certificatetree;


import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class CertificateTreeParser extends AbstractListParser<CertificateTreeResponse, ApiCertificateCategory> {
	public CertificateTreeParser() {
		super(CertificateTreeResponse.class, 2, ApiPath.EVE, ApiPage.CERTIFICATE_TREE, ApiCertificateCategory.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiCertificateClass.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row/rowset/row", ApiCertificate.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row/rowset/row");
		digester.addFactoryCreate("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row",
				new AbstractObjectCreationFactory() {
					@Override
					public Object createObject(Attributes attributes) throws Exception {
						if (attributes.getValue("typeID") != null)
							return new RequiredSkill();
						if (attributes.getValue("certificateID") != null)
							return new RequiredCertificate();
						return null;
					}
				});
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row", "add");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row/rowset/row", "add");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "add");
		return digester;
	}

	public static CertificateTreeParser getInstance() {
		return new CertificateTreeParser();
	}

	@Override
	public CertificateTreeResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}