package com.beimin.eveapi.shared.assetlist;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractAssetListParser extends AbstractApiParser<AssetListResponse> {
	protected static final String ASSETLIST_URL = "/AssetList";

	protected AbstractAssetListParser(Path path) {
		super(AssetListResponse.class, 2, path, ASSETLIST_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("*/rowset/row", ApiAsset.class);
		digester.addSetProperties("*/rowset/row");
		digester.addSetNext("*/rowset/row", "addAsset");
		return digester;
	}

	public AssetListResponse getAssetListResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	public Collection<ApiAsset> getAssets(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth).getAssets();
	}
}