package com.beimin.eveapi.eve.character;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class CharacterInfoParser extends AbstractApiParser<CharacterInfoResponse> {
	public CharacterInfoParser() {
		super(CharacterInfoResponse.class, 2, ApiPath.EVE, ApiPage.CHARACTER_INFO);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/characterID");
		digester.addBeanPropertySetter("eveapi/result/characterName");
		digester.addBeanPropertySetter("eveapi/result/race");
		digester.addBeanPropertySetter("eveapi/result/bloodline");
		digester.addBeanPropertySetter("eveapi/result/accountBalance");
		digester.addBeanPropertySetter("eveapi/result/skillPoints");
		digester.addBeanPropertySetter("eveapi/result/shipName");
		digester.addBeanPropertySetter("eveapi/result/shipTypeID");
		digester.addBeanPropertySetter("eveapi/result/shipTypeName");
		digester.addBeanPropertySetter("eveapi/result/corporationID");
		digester.addBeanPropertySetter("eveapi/result/corporation");
		digester.addBeanPropertySetter("eveapi/result/corporationDate");
		digester.addBeanPropertySetter("eveapi/result/allianceID");
		digester.addBeanPropertySetter("eveapi/result/alliance");
		digester.addBeanPropertySetter("eveapi/result/allianceDate");
		digester.addBeanPropertySetter("eveapi/result/lastKnownLocation");
		digester.addBeanPropertySetter("eveapi/result/securityStatus");
		return digester;
	}

	public static CharacterInfoParser getInstance() {
		return new CharacterInfoParser();
	}

	public CharacterInfoResponse getResponse(int characterID) throws ApiException {
		return super.getResponse("characterID", Integer.toString(characterID));
	}

	@Override
	public CharacterInfoResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}
}