package com.beimin.eveapi.corporation.shareholders;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class ShareholdersHandler extends AbstractContentListHandler<ShareholdersResponse, ApiShareholder> {
	public ShareholdersHandler() {
		super(ShareholdersResponse.class);
	}

	@Override
	protected ApiShareholder getItem(Attributes attrs) {
		ApiShareholder item = new ApiShareholder();
		item.setShareholderCorporationID(getLong(attrs, "shareholderCorporationID"));
		item.setShareholderCorporationName(getString(attrs, "shareholderCorporationName"));
		item.setShareholderID(getLong(attrs, "shareholderID"));
		item.setShareholderName(getString(attrs, "shareholderName"));
		item.setShares(getInt(attrs, "shares"));
		return item;
	}
}