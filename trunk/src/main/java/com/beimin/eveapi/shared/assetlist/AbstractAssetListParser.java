package com.beimin.eveapi.shared.assetlist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public abstract class AbstractAssetListParser extends AbstractApiParser<AssetListResponse> {
	protected AbstractAssetListParser(ApiPath path) {
		super(AssetListResponse.class, 2, path, ApiPage.ASSET_LIST);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("*/rowset/row", ApiAsset.class);
		digester.addSetProperties("*/rowset/row");
		digester.addSetNext("*/rowset/row", "addAsset");
		return digester;
	}

	@Override
	public AssetListResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}