package com.beimin.eveapi;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Set;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.BeforeClass;
import org.junit.Test;

import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.account.AccountStatus;
import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.model.shared.EveAccountBalance;
import com.beimin.eveapi.model.shared.KeyType;
import com.beimin.eveapi.parser.ApiAuthorization;
import com.beimin.eveapi.utils.EveApiRouteBuilder;
import com.beimin.eveapi.utils.MockApi;

public class EveApiTest {
	private static EveApi eveApi;
	private static final CamelContext context = new DefaultCamelContext();
	private static Character testCharacter;

	@BeforeClass
	public static void setup() throws Exception {
		ApiAuthorization auth = new ApiAuthorization(123, "abc");
		eveApi = new EveApi(auth);
		context.addRoutes(new EveApiRouteBuilder());
		context.start();
		EveApi.setConnector(new ApiConnector(MockApi.URL));
		testCharacter = new Character();
		testCharacter.setCharacterID(46135126);
		testCharacter.setName("Test Character 1");
		testCharacter.setCorporationID(71643215);
		testCharacter.setCorporationName("Emipre Alt corp");
	}

	@Test
	public void getAccountStatus() throws ApiException {
		AccountStatus accountStatus = eveApi.getAccountStatus();
		assertNotNull(accountStatus);
		assertEquals(541354, accountStatus.getUserID());
		assertDate(2011, 03, 13, 18, 40, 0, accountStatus.getPaidUntil());
		assertDate(2004, 07, 22, 23, 54, 0, accountStatus.getCreateDate());
		assertEquals(5603, accountStatus.getLogonCount());
		assertEquals(504903, accountStatus.getLogonMinutes());
	}

	@Test
	public void getCharacters() throws ApiException {
		Set<Character> eveCharacters = eveApi.getCharacters();
		assertNotNull(eveCharacters);
		assertEquals(2, eveCharacters.size());
		for (Character eveCharacter : eveCharacters) {
			long characterID = eveCharacter.getCharacterID();
			if (characterID == 46135126) {
				assertEquals("Test Character 1", eveCharacter.getName());
				assertEquals(71643215, eveCharacter.getCorporationID());
				assertEquals("Emipre Alt corp", eveCharacter.getCorporationName());
			} else if (characterID == 416541356) {
				assertEquals("Test Character 2", eveCharacter.getName());
				assertEquals(416513245, eveCharacter.getCorporationID());
				assertEquals("Deepspace Explorations", eveCharacter.getCorporationName());
			} else {
				fail();
			}
		}
	}

	@Test
	public void getAccountBalance() throws ApiException {
		eveApi.selectCharacter(testCharacter);
		EveAccountBalance accountBalance = eveApi.getAccountBalance(KeyType.Character).iterator().next();
		assertNotNull(accountBalance);
		assertEquals(10094361, accountBalance.getAccountID());
		assertEquals(1000, accountBalance.getAccountKey());
		assertEquals(46634844.84, accountBalance.getBalance(), 0.00001);
	}
}