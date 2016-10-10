package com.beimin.eveapi.eve.character;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.CharacterLookup;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.CharacterLookupParser;
import com.beimin.eveapi.response.eve.CharacterLookupResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class CharacterIDLookupParserTest extends NoAuthParserTest {
    public CharacterIDLookupParserTest() {
        super(ApiPath.EVE, ApiPage.CHARACTER_ID);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharacterLookupParser parser = CharacterLookupParser.getName2IdInstance();
        final CharacterLookupResponse response = parser.getResponse("CCP Garthagk");
        final Collection<CharacterLookup> chars = response.getAll();
        assertEquals(1, chars.size());
        final CharacterLookup garthagk = chars.iterator().next();
        assertEquals("CCP Garthagk", garthagk.getName());
        assertEquals(797400947, garthagk.getCharacterID());
    }

    @Override
    public void extraAsserts(final Map<String, String> req) {
        super.extraAsserts(req);
        assertEquals("CCP Garthagk", req.get("names"));
    }
}

