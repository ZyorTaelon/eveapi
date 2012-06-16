package com.beimin.eveapi.corporation.shareholders;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class ShareholdersParser extends AbstractApiParser<ShareholdersResponse> {
	protected static final String SHAREHOLDERS_URL = "/Shareholders.xml.aspx";

	public ShareholdersParser() {
		super(ShareholdersResponse.class, 2, SHAREHOLDERS_URL);
	}

	public ShareholdersResponse getShareholders(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.CORP);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiShareholder.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addShareholder");
		return digester;
	}

	public static ShareholdersParser getInstance() {
		return new ShareholdersParser();
	}
}