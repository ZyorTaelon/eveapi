package com.beimin.eveapi.account.apikeyinfo;

import com.beimin.eveapi.account.characters.EveCharacter;
import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;


public class ApiKeyInfoParser extends AbstractApiParser<ApiKeyInfoResponse> {
	public ApiKeyInfoParser() {
		super(ApiKeyInfoResponse.class, 2, ApiPath.ACCOUNT, ApiPage.API_KEY_INFO);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addSetProperties("eveapi/result/key");

		digester.addObjectCreate("eveapi/result/key/rowset/row", EveCharacter.class);
		digester.addSetProperties("eveapi/result/key/rowset/row");
		digester.addSetProperties("eveapi/result/key/rowset/row", "characterName", "name");
		digester.addSetNext("eveapi/result/key/rowset/row", "addEveCharacter");
		return digester;
	}

	public static ApiKeyInfoParser getInstance() {
		return new ApiKeyInfoParser();
	}

	@Override
	public ApiKeyInfoResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}
