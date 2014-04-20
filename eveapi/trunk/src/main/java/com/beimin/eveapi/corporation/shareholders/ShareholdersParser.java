package com.beimin.eveapi.corporation.shareholders;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class ShareholdersParser extends AbstractListParser<ShareholdersHandler, ShareholdersResponse, ApiShareholder> {
	public ShareholdersParser() {
		super(ShareholdersResponse.class, 2, ApiPath.CORPORATION, ApiPage.SHAREHOLDERS, ShareholdersHandler.class);
	}

	@Override
	public ShareholdersResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}