package com.beimin.eveapi.response.character;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.model.character.Medal;
import com.beimin.eveapi.response.ApiListResponse;

public class MedalsResponse extends ApiListResponse<Medal> {

    private final List<Medal> currentCorporation = new ArrayList<>();
    private final List<Medal> otherCorporations = new ArrayList<>();

    public void addCurrentCorporation(Medal medal) {
        currentCorporation.add(medal);
    }

    public List<Medal> getCurrentCorporation() {
        return currentCorporation;
    }

    public void addOtherCorporations(Medal medal) {
        otherCorporations.add(medal);
    }

    public List<Medal> getOtherCorporations() {
        return otherCorporations;
    }
}
