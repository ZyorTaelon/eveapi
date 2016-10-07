package com.beimin.eveapi.model.eve;

public class FactionKills extends FactionStat implements KillStat {
    private int kills;

    @Override
    public int getKills() {
        return kills;
    }

    @Override
    public void setKills(final int kills) {
        this.kills = kills;
    }
}