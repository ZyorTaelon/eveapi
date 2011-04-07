package com.beimin.eveapi.corporation.shareholders;


import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ShareholdersParser extends AbstractApiParser<ShareholdersResponse> {
	public ShareholdersParser() {
		super(ShareholdersResponse.class, 2, ApiPath.CORPORATION, ApiPage.SHAREHOLDERS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiShareholder.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	public static ShareholdersParser getInstance() {
		return new ShareholdersParser();
	}

	@Override
	public ShareholdersResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}