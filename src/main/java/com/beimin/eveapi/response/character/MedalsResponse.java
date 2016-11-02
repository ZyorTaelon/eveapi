package com.beimin.eveapi.response.character;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.model.character.Medal;
import com.beimin.eveapi.response.ApiListResponse;

public class MedalsResponse extends ApiListResponse<Medal> {

    private final Set<Medal> currentCorporation = new HashSet<>();
    private final Set<Medal> otherCorporations = new HashSet<>();

    public void addCurrentCorporation(Medal medal) {
        currentCorporation.add(medal);
    }

    public Set<Medal> getCurrentCorporation() {
        return currentCorporation;
    }

    public void addOtherCorporations(Medal medal) {
        otherCorporations.add(medal);
    }

    public Set<Medal> getOtherCorporations() {
        return otherCorporations;
    }
}
