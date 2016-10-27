package com.beimin.eveapi.response.eve;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.model.eve.CharacterKills;
import com.beimin.eveapi.model.eve.CharacterVictoryPoints;
import com.beimin.eveapi.model.eve.CorporationKills;
import com.beimin.eveapi.model.eve.CorporationVictoryPoints;
import com.beimin.eveapi.model.eve.FacWarStat;
import com.beimin.eveapi.model.eve.FactionKills;
import com.beimin.eveapi.model.eve.FactionVictoryPoints;
import com.beimin.eveapi.response.ApiResponse;

public class FacWarTopStatsResponse extends ApiResponse {
    private final List<CharacterKills> charactersKillsYesterday = new ArrayList<CharacterKills>();
    private final List<CharacterKills> charactersKillsLastWeek = new ArrayList<CharacterKills>();
    private final List<CharacterKills> charactersKillsTotal = new ArrayList<CharacterKills>();
    private final List<CharacterVictoryPoints> charactersVictoryPointsYesterday = new ArrayList<CharacterVictoryPoints>();
    private final List<CharacterVictoryPoints> charactersVictoryPointsLastWeek = new ArrayList<CharacterVictoryPoints>();
    private final List<CharacterVictoryPoints> charactersVictoryPointsTotal = new ArrayList<CharacterVictoryPoints>();
    private final List<CorporationKills> corporationsKillsYesterday = new ArrayList<CorporationKills>();
    private final List<CorporationKills> corporationsKillsLastWeek = new ArrayList<CorporationKills>();
    private final List<CorporationKills> corporationsKillsTotal = new ArrayList<CorporationKills>();
    private final List<CorporationVictoryPoints> corporationsVictoryPointsYesterday = new ArrayList<CorporationVictoryPoints>();
    private final List<CorporationVictoryPoints> corporationsVictoryPointsLastWeek = new ArrayList<CorporationVictoryPoints>();
    private final List<CorporationVictoryPoints> corporationsVictoryPointsTotal = new ArrayList<CorporationVictoryPoints>();
    private final List<FactionKills> factionsKillsYesterday = new ArrayList<FactionKills>();
    private final List<FactionKills> factionsKillsLastWeek = new ArrayList<FactionKills>();
    private final List<FactionKills> factionsKillsTotal = new ArrayList<FactionKills>();
    private final List<FactionVictoryPoints> factionsVictoryPointsYesterday = new ArrayList<FactionVictoryPoints>();
    private final List<FactionVictoryPoints> factionsVictoryPointsLastWeek = new ArrayList<FactionVictoryPoints>();
    private final List<FactionVictoryPoints> factionsVictoryPointsTotal = new ArrayList<FactionVictoryPoints>();

    public void addYesterday(final FacWarStat stat) {
        if (stat instanceof CharacterKills) {
            charactersKillsYesterday.add((CharacterKills) stat);
        } else if (stat instanceof CharacterVictoryPoints) {
            charactersVictoryPointsYesterday.add((CharacterVictoryPoints) stat);
        } else if (stat instanceof CorporationKills) {
            corporationsKillsYesterday.add((CorporationKills) stat);
        } else if (stat instanceof CorporationVictoryPoints) {
            corporationsVictoryPointsYesterday.add((CorporationVictoryPoints) stat);
        } else if (stat instanceof FactionKills) {
            factionsKillsYesterday.add((FactionKills) stat);
        } else if (stat instanceof FactionVictoryPoints) {
            factionsVictoryPointsYesterday.add((FactionVictoryPoints) stat);
        }
    }

    public void addLastWeek(final FacWarStat stat) {
        if (stat instanceof CharacterKills) {
            charactersKillsLastWeek.add((CharacterKills) stat);
        } else if (stat instanceof CharacterVictoryPoints) {
            charactersVictoryPointsLastWeek.add((CharacterVictoryPoints) stat);
        } else if (stat instanceof CorporationKills) {
            corporationsKillsLastWeek.add((CorporationKills) stat);
        } else if (stat instanceof CorporationVictoryPoints) {
            corporationsVictoryPointsLastWeek.add((CorporationVictoryPoints) stat);
        } else if (stat instanceof FactionKills) {
            factionsKillsLastWeek.add((FactionKills) stat);
        } else if (stat instanceof FactionVictoryPoints) {
            factionsVictoryPointsLastWeek.add((FactionVictoryPoints) stat);
        }
    }

    public void addTotal(final FacWarStat stat) {
        if (stat instanceof CharacterKills) {
            charactersKillsTotal.add((CharacterKills) stat);
        } else if (stat instanceof CharacterVictoryPoints) {
            charactersVictoryPointsTotal.add((CharacterVictoryPoints) stat);
        } else if (stat instanceof CorporationKills) {
            corporationsKillsTotal.add((CorporationKills) stat);
        } else if (stat instanceof CorporationVictoryPoints) {
            corporationsVictoryPointsTotal.add((CorporationVictoryPoints) stat);
        } else if (stat instanceof FactionKills) {
            factionsKillsTotal.add((FactionKills) stat);
        } else if (stat instanceof FactionVictoryPoints) {
            factionsVictoryPointsTotal.add((FactionVictoryPoints) stat);
        }
    }

    public List<CharacterKills> getCharactersKillsYesterday() {
        return charactersKillsYesterday;
    }

    public List<CharacterKills> getCharactersKillsLastWeek() {
        return charactersKillsLastWeek;
    }

    public List<CharacterKills> getCharactersKillsTotal() {
        return charactersKillsTotal;
    }

    public List<CharacterVictoryPoints> getCharactersVictoryPointsYesterday() {
        return charactersVictoryPointsYesterday;
    }

    public List<CharacterVictoryPoints> getCharactersVictoryPointsLastWeek() {
        return charactersVictoryPointsLastWeek;
    }

    public List<CharacterVictoryPoints> getCharactersVictoryPointsTotal() {
        return charactersVictoryPointsTotal;
    }

    public List<CorporationKills> getCorporationsKillsYesterday() {
        return corporationsKillsYesterday;
    }

    public List<CorporationKills> getCorporationsKillsLastWeek() {
        return corporationsKillsLastWeek;
    }

    public List<CorporationKills> getCorporationsKillsTotal() {
        return corporationsKillsTotal;
    }

    public List<CorporationVictoryPoints> getCorporationsVictoryPointsYesterday() {
        return corporationsVictoryPointsYesterday;
    }

    public List<CorporationVictoryPoints> getCorporationsVictoryPointsLastWeek() {
        return corporationsVictoryPointsLastWeek;
    }

    public List<CorporationVictoryPoints> getCorporationsVictoryPointsTotal() {
        return corporationsVictoryPointsTotal;
    }

    public List<FactionKills> getFactionsKillsYesterday() {
        return factionsKillsYesterday;
    }

    public List<FactionKills> getFactionsKillsLastWeek() {
        return factionsKillsLastWeek;
    }

    public List<FactionKills> getFactionsKillsTotal() {
        return factionsKillsTotal;
    }

    public List<FactionVictoryPoints> getFactionsVictoryPointsYesterday() {
        return factionsVictoryPointsYesterday;
    }

    public List<FactionVictoryPoints> getFactionsVictoryPointsLastWeek() {
        return factionsVictoryPointsLastWeek;
    }

    public List<FactionVictoryPoints> getFactionsVictoryPointsTotal() {
        return factionsVictoryPointsTotal;
    }
}
