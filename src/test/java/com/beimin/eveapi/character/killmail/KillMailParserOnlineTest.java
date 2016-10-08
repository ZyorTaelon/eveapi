package com.beimin.eveapi.character.killmail;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.character.AbstractCharacterOnlineTest;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Kill;
import com.beimin.eveapi.parser.pilot.KillMailParser;
import com.beimin.eveapi.parser.shared.AbstractKillMailParser;
import com.beimin.eveapi.response.shared.KillMailResponse;

public class KillMailParserOnlineTest extends AbstractCharacterOnlineTest {
    @Test
    public void getResponse() throws ApiException {
        final AbstractKillMailParser parser = new KillMailParser();
        final KillMailResponse response = parser.getResponse(getApiAuth());
        assertThat(response, notNullValue());
        assertThat(response.getError(), nullValue());
        checkResponse(response);
        final Set<Kill> kills = response.getAll();
        assertThat(kills.size(), greaterThan(0));
        checkBean(kills.iterator().next());
    }

    private void checkResponse(final KillMailResponse response) {
        assertThat(response.getCachedUntil(), notNullValue());
        assertThat(response.getCurrentTime(), notNullValue());
        assertThat(response.getVersion(), equalTo(2));
    }

    @Override
    protected List<String> getEmptyStringMethods() {
        final List<String> methods = new ArrayList<String>();
        methods.add("getAllianceName");
        methods.add("getCharacterName"); // Concord officers don't have a character name ;-)
        methods.add("getFactionName");
        return methods;
    }
}
