package com.beimin.eveapi.account.characters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CharactersParserTest extends FullAuthParserTest {
	public CharactersParserTest() {
		super(ApiPath.ACCOUNT, ApiPage.CHARACTERS);
	}

	@Test
	public void getResponse() throws ApiException {
		CharactersParser parser = CharactersParser.getInstance();
		CharactersResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Collection<EveCharacter> eveCharacters = response.getAll();
		assertEquals(2, eveCharacters.size());
		for (EveCharacter eveCharacter : eveCharacters) {
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
}