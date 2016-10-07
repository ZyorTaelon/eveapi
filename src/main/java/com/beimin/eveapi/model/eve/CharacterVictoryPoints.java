package com.beimin.eveapi.model.eve;

public class CharacterVictoryPoints extends CharacterStat implements VictoryPointsStat {
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