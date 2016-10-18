package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.eve.FactionStats;
import com.beimin.eveapi.model.eve.FactionWar;
import com.beimin.eveapi.response.eve.FacWarStatsResponse;

public class FacWarStatsHandler extends AbstractContentHandler<FacWarStatsResponse> {
    private boolean factions;
    private boolean factionWars;

    @Override
    public void startDocument() throws SAXException {
        setResponse(new FacWarStatsResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        final FacWarStatsResponse response = getResponse();
        if (ELEMENT_ROWSET.equals(qName)) {
            final String name = getString(attrs, "name");
            factions = name.equals("factions");
            factionWars = name.equals("factionWars");
        } else if (ELEMENT_ROW.equals(qName)) {
            if (factions) {
                final FactionStats item = new FactionStats();
                saveFieldsCount(FactionStats.class, attrs);
                item.setFactionID(getInt(attrs, "factionID"));
                item.setFactionName(getString(attrs, "factionName"));
                item.setPilots(getInt(attrs, "pilots"));
                item.setSystemsControlled(getInt(attrs, "systemsControlled"));
                item.setKillsYesterday(getInt(attrs, "killsYesterday"));
                item.setKillsLastWeek(getInt(attrs, "killsLastWeek"));
                item.setKillsTotal(getInt(attrs, "killsTotal"));
                item.setVictoryPointsYesterday(getInt(attrs, "victoryPointsYesterday"));
                item.setVictoryPointsLastWeek(getInt(attrs, "victoryPointsLastWeek"));
                item.setVictoryPointsTotal(getInt(attrs, "victoryPointsTotal"));
                response.addStat(item);
            } else if (factionWars) {
                final FactionWar item = new FactionWar();
                saveFieldsCount(FactionWar.class, attrs);
                item.setFactionID(getInt(attrs, "factionID"));
                item.setFactionName(getString(attrs, "factionName"));
                item.setAgainstID(getInt(attrs, "againstID"));
                item.setAgainstName(getString(attrs, "againstName"));
                response.addStat(item);
            }
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        final FacWarStatsResponse response = getResponse();
        if ("killsYesterday".equals(qName)) {
            response.setKillsYesterday(getInt());
        } else if ("killsLastWeek".equals(qName)) {
            response.setKillsLastWeek(getInt());
        } else if ("killsTotal".equals(qName)) {
            response.setKillsTotal(getInt());
        } else if ("victoryPointsYesterday".equals(qName)) {
            response.setVictoryPointsYesterday(getInt());
        } else if ("victoryPointsLastWeek".equals(qName)) {
            response.setVictoryPointsLastWeek(getInt());
        } else if ("victoryPointsTotal".equals(qName)) {
            response.setVictoryPointsTotal(getInt());
        } else if (ELEMENT_ROWSET.equals(qName)) {
            factions = false;
            factionWars = false;
        }
    }
}
