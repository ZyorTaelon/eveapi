package com.beimin.eveapi.character.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.account.characters.ApiCharacter;
import com.beimin.eveapi.account.characters.CharactersParser;
import com.beimin.eveapi.account.characters.CharactersResponse;

public class ParserTest {

	@Test
	public void testCharacterListParser() throws IOException, SAXException, ParseException {
		CharactersParser parser = CharactersParser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/Characters.xml");
		CharactersResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiCharacter> eveCharacters = response.getEveCharacters();
		assertEquals(2, eveCharacters.size());
		for (ApiCharacter eveCharacter : eveCharacters) {
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