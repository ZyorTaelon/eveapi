package com.beimin.eveapi.model.eve;

public class FactionVictoryPoints extends FactionStat implements VictoryPointsStat {
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