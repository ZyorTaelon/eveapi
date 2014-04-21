package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.corporation.ShareholdersHandler;
import com.beimin.eveapi.model.corporation.Shareholder;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.corporation.ShareholdersResponse;

public class ShareholdersParser extends AbstractListParser<ShareholdersHandler, ShareholdersResponse, Shareholder> {
	public ShareholdersParser() {
		super(ShareholdersResponse.class, 2, ApiPath.CORPORATION, ApiPage.SHAREHOLDERS, ShareholdersHandler.class);
	}

	@Override
	public ShareholdersResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}