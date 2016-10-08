package com.beimin.eveapi.response.corporation;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.model.corporation.Shareholder;
import com.beimin.eveapi.response.ApiListResponse;

public class ShareholdersResponse extends ApiListResponse<Shareholder> {
    private final Collection<Shareholder> characters = new ArrayList<Shareholder>();
    private final Collection<Shareholder> corporations = new ArrayList<Shareholder>();

    @Override
    public void add(final Shareholder shareholder) {
        if (shareholder.getShareholderCorporationName() == null) {
            corporations.add(shareholder);
        } else {
            characters.add(shareholder);
        }
    }

    public Collection<Shareholder> getCharacters() {
        return characters;
    }

    public Collection<Shareholder> getCorporations() {
        return corporations;
    }
}

