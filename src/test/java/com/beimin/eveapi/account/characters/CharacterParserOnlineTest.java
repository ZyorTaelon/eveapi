package com.beimin.eveapi.account.characters;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.character.AbstractCharacterOnlineTest;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.parser.account.CharactersParser;
import com.beimin.eveapi.response.account.CharactersResponse;

public class CharacterParserOnlineTest extends AbstractCharacterOnlineTest {
    @Test
    public void getResponse() throws ApiException {
        CharactersParser parser = new CharactersParser();
        CharactersResponse response = parser.getResponse(getApiAuth());
        assertThat(response, notNullValue());
        Set<Character> characters = response.getAll();
        assertThat(characters.size(), equalTo(1));
        Character character = characters.iterator().next();
        assertThat(character.getName(), equalTo("Glazeg"));
    }

    @Override
    protected List<String> getEmptyStringMethods() {
        return null;
    }
}
