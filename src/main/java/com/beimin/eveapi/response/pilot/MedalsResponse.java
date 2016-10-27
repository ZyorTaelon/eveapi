package com.beimin.eveapi.response.pilot;

import com.beimin.eveapi.model.pilot.Medal;
import com.beimin.eveapi.response.ApiListResponse;
import java.util.HashSet;
import java.util.Set;

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
