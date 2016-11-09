package com.beimin.eveapi.account.apikeyinfo;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

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
        assertThat(response, notNullValue());

        assertThat(response.getAccessMask(), equalTo(4227l));
        assertThat(response.getExpires(), nullValue());

        assertThat(response.getEveCharacters().size(), equalTo(3));

        final List<Character> characters = new ArrayList<Character>(response.getEveCharacters());

        Character character1 = characters.get(0);
        assertThat(character1.getCharacterID(), equalTo(987623974l));
        assertThat(character1.getName(), equalTo("Golden Gnu"));
        assertThat(character1.getCorporationID(), equalTo(1020386980l));
        assertThat(character1.getCorporationName(), equalTo("The Golden Gnu Corp"));
        assertThat(character1.getAllianceID(), equalTo(123456789l));
        assertThat(character1.getAllianceName(), equalTo("Generic Test Alliance"));
        assertThat(character1.getFactionID(), equalTo(987654321l));
        assertThat(character1.getFactionName(), equalTo("Generic Test Faction"));

        Character character2 = characters.get(1);
        assertThat(character2.getCharacterID(), equalTo(1652509239l));
        assertThat(character2.getName(), equalTo("GoldenGnu"));
        assertThat(character2.getCorporationID(), equalTo(1020386980l));
        assertThat(character2.getCorporationName(), equalTo("The Golden Gnu Corp"));
        assertThat(character2.getAllianceID(), equalTo(123456789l));
        assertThat(character2.getAllianceName(), equalTo("Generic Test Alliance"));
        assertThat(character2.getFactionID(), equalTo(987654321l));
        assertThat(character2.getFactionName(), equalTo("Generic Test Faction"));

        Character character3 = characters.get(2);
        assertThat(character3.getCharacterID(), equalTo(1683690353l));
        assertThat(character3.getName(), equalTo("Silver Gnu"));
        assertThat(character3.getCorporationID(), equalTo(1020386980l));
        assertThat(character3.getCorporationName(), equalTo("The Golden Gnu Corp"));
        assertThat(character3.getAllianceID(), equalTo(123456789l));
        assertThat(character3.getAllianceName(), equalTo("Generic Test Alliance"));
        assertThat(character3.getFactionID(), equalTo(987654321l));
        assertThat(character3.getFactionName(), equalTo("Generic Test Faction"));
    }
}
