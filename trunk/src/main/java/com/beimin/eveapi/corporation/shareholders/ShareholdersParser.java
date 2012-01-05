package com.beimin.eveapi.corporation.shareholders;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ShareholdersParser extends AbstractListParser<ShareholdersHandler, ShareholdersResponse, ApiShareholder> {
	public ShareholdersParser() {
		super(ShareholdersResponse.class, 2, ApiPath.CORPORATION, ApiPage.SHAREHOLDERS, ShareholdersHandler.class);
	}

	public static ShareholdersParser getInstance() {
		return new ShareholdersParser();
	}

	@Override
	public ShareholdersResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}