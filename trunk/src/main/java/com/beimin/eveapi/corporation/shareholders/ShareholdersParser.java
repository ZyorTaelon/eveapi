package com.beimin.eveapi.corporation.shareholders;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class ShareholdersParser extends AbstractApiParser<ShareholdersResponse> {
	public ShareholdersParser() {
		super(ShareholdersResponse.class, 2, ApiPath.CORPORATION, ApiPage.SHAREHOLDERS);
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

	public ShareholdersResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}