package com.beimin.eveapi.eve.certificatetree;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class CertificateTreeParser extends AbstractApiParser<CertificateTreeResponse> {
	public CertificateTreeParser() {
		super(CertificateTreeResponse.class, 2, ApiPath.EVE, ApiPage.CERTIFICATE_TREE);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiCertificateCategory.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiCertificateClass.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row/rowset/row", ApiCertificate.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row/rowset/row");
		digester.addFactoryCreate("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row", new AbstractObjectCreationFactory() {
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
		digester.addSetNext("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row", "addRequirement");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row/rowset/row", "addCertificate");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addCertificateClass");
		digester.addSetNext("eveapi/result/rowset/row", "addCertificateCategory");
		return digester;
	}

	public static CertificateTreeParser getInstance() {
		return new CertificateTreeParser();
	}

	public CertificateTreeResponse getResponse() throws IOException, SAXException {
		return super.getResponse();
	}
}