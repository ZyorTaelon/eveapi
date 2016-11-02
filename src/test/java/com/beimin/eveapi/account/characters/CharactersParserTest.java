package com.beimin.eveapi.account.characters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.account.CharactersParser;
import com.beimin.eveapi.response.account.CharactersResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CharactersParserTest extends FullAuthParserTest {
    public CharactersParserTest() {
        super(ApiPath.ACCOUNT, ApiPage.CHARACTERS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharactersParser parser = new CharactersParser();
        final CharactersResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final Collection<Character> eveCharacters = response.getAll();
        assertEquals(2, eveCharacters.size());
        for (final Character eveCharacter : eveCharacters) {
            final long characterID = eveCharacter.getCharacterID();
            if (characterID == 46135126) {
                assertEquals("Test Character 1", eveCharacter.getName());
                assertEquals(71643215, eveCharacter.getCorporationID());
                assertEquals("Emipre Alt corp", eveCharacter.getCorporationName());
                assertEquals(123456789, eveCharacter.getAllianceID());
                assertEquals("Generic Test Alliance", eveCharacter.getAllianceName());
                assertEquals(987654321, eveCharacter.getFactionID());
                assertEquals("Generic Test Faction", eveCharacter.getFactionName());
            } else if (characterID == 416541356) {
                assertEquals("Test Character 2", eveCharacter.getName());
                assertEquals(416513245, eveCharacter.getCorporationID());
                assertEquals("Deepspace Explorations", eveCharacter.getCorporationName());
                assertEquals(123456789, eveCharacter.getAllianceID());
                assertEquals("Generic Test Alliance", eveCharacter.getAllianceName());
                assertEquals(987654321, eveCharacter.getFactionID());
                assertEquals("Generic Test Faction", eveCharacter.getFactionName());
            } else {
                fail();
            }
        }
    }
}
