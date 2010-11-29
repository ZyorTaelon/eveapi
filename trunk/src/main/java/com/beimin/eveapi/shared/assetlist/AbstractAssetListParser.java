package com.beimin.eveapi.shared.assetlist;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractAssetListParser extends AbstractApiParser<AssetListResponse> {
	protected static final String ASSETLIST_URL = "/AssetList";
	private final Path path;

	protected AbstractAssetListParser(Path path) {
		super(AssetListResponse.class, 2, ASSETLIST_URL);
		this.path = path;
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
		return getResponse(auth, path);
	}

	public Collection<ApiAsset> getAssets(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, path).getAssets();
	}
}