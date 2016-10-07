package com.beimin.eveapi.eve.character;

import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.eve.CharacterInfoParser;
import com.beimin.eveapi.response.eve.CharacterInfoResponse;

public class CharacterInfoParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponsePublic() throws Exception {
		//Not in alliance
		addNullOk("getAllianceID"); 
		addNullOk("getAllianceDate");
		addNullOk("getAlliance");
		//Private Info, not included
		addNullOk("getShipName");
		addNullOk("getAccountBalance");
		addNullOk("getLastKnownLocation");
		addNullOk("getShipTypeID");
		addNullOk("getSkillPoints");
		addNullOk("getShipTypeName");
		addEmptyOK("getSecurityStatus"); //Security Status can be zero
		CharacterInfoParser parser = new CharacterInfoParser();
		CharacterInfoResponse response = parser.getResponse(getCharacterID());
		testResponse(response);
	}

	@Test
	public void getResponseKeyFull() throws Exception {
		//Not in alliance
		addNullOk("getAllianceID"); 
		addNullOk("getAllianceDate");
		addNullOk("getAlliance");
		CharacterInfoParser parser = new CharacterInfoParser();
		CharacterInfoResponse response = parser.getResponse(getEve());
		testResponse(response);
	}

	@Test
	public void getResponseKeyLimited() throws Exception {
		testFail("Limited Key is not tested");
		//Not in alliance
		addNullOk("getAllianceID"); 
		addNullOk("getAllianceDate");
		addNullOk("getAlliance");
		CharacterInfoParser parser = new CharacterInfoParser();
		CharacterInfoResponse response = parser.getResponse(getEve());
		testResponse(response);
	}

}