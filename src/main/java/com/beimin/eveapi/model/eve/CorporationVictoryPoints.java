package com.beimin.eveapi.model.eve;

public class CorporationVictoryPoints extends CorporationStat implements VictoryPointsStat {
    private int victoryPoints;

    @Override
    public int getVictoryPoints() {
        return victoryPoints;
    }

    @Override
    public void setVictoryPoints(final int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }
}
