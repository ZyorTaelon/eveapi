package com.beimin.eveapi.account.apikeyinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.account.ApiKeyInfoParser;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ApiKeyInfoParserTest extends FullAuthParserTest {
    public ApiKeyInfoParserTest() {
        super(ApiPath.ACCOUNT, ApiPage.API_KEY_INFO);
    }

    @Test
    public void getResponse() throws Exception {
        final ApiKeyInfoParser apiKeyInfoParser = new ApiKeyInfoParser();
        final ApiKeyInfoResponse response = apiKeyInfoParser.getResponse(auth);
        assertNotNull(response);

        assertEquals(4227, response.getAccessMask());
        assertNull(response.getExpires());

        assertEquals(3, response.getEveCharacters().size());

        final List<Character> characters = new ArrayList<Character>(response.getEveCharacters());

        assertEquals(987623974, characters.get(0).getCharacterID());
        assertEquals("Golden Gnu", characters.get(0).getName());
        assertEquals(1020386980, characters.get(0).getCorporationID());
        assertEquals("The Golden Gnu Corp", characters.get(0).getCorporationName());
        assertEquals(123456789, characters.get(0).getAllianceID());
        assertEquals("Generic Test Alliance", characters.get(0).getAllianceName());
        assertEquals(987654321, characters.get(0).getFactionID());
        assertEquals("Generic Test Faction", characters.get(0).getFactionName());

        assertEquals(1652509239, characters.get(1).getCharacterID());
        assertEquals("GoldenGnu", characters.get(1).getName());
        assertEquals(1020386980, characters.get(1).getCorporationID());
        assertEquals("The Golden Gnu Corp", characters.get(1).getCorporationName());
        assertEquals(123456789, characters.get(1).getAllianceID());
        assertEquals("Generic Test Alliance", characters.get(1).getAllianceName());
        assertEquals(987654321, characters.get(1).getFactionID());
        assertEquals("Generic Test Faction", characters.get(1).getFactionName());

        assertEquals(1683690353, characters.get(2).getCharacterID());
        assertEquals("Silver Gnu", characters.get(2).getName());
        assertEquals(1020386980, characters.get(2).getCorporationID());
        assertEquals("The Golden Gnu Corp", characters.get(2).getCorporationName());
        assertEquals(123456789, characters.get(2).getAllianceID());
        assertEquals("Generic Test Alliance", characters.get(2).getAllianceName());
        assertEquals(987654321, characters.get(2).getFactionID());
        assertEquals("Generic Test Faction", characters.get(2).getFactionName());
    }
}
