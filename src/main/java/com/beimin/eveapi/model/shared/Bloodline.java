package com.beimin.eveapi.model.shared;

public enum Bloodline {
    CIVIRE(Race.CALDARI), //
    DETEIS(Race.CALDARI), //
    ACHURA(Race.CALDARI), //
    GALLENTE(Race.GALLENTE), //
    INTAKI(Race.GALLENTE), //
    JIN_MEI(Race.GALLENTE), //
    AMARR(Race.AMARR), //
    KHANID(Race.AMARR), //
    NI_KUNNI(Race.AMARR), //
    BRUTOR(Race.MINMATAR), //
    SEBIESTOR(Race.MINMATAR), //
    VHEROKIOR(Race.MINMATAR);
    private final Race race;

    Bloodline(final Race race) {
        this.race = race;
    }

    public Race getRace() {
        return race;
    }

    public Ancestry[] getAncestries() {
        Ancestry[] result = null;
        switch (this) {
        case CIVIRE:
            result = new Ancestry[] { Ancestry.DISSENTERS, Ancestry.MERCS, Ancestry.ENTREPRENEURS };
            break;
        case DETEIS:
            result = new Ancestry[] { Ancestry.TUBE_CHILD, Ancestry.SCIENTISTS, Ancestry.MERCHANDISERS };
            break;
        case ACHURA:
            result = new Ancestry[] { Ancestry.INVENTORS, Ancestry.MONKS, Ancestry.STARGAZERS };
            break;
        case GALLENTE:
            result = new Ancestry[] { Ancestry.ACTIVISTS, Ancestry.IMMIGRANTS, Ancestry.MINERS };
            break;
        case INTAKI:
            result = new Ancestry[] { Ancestry.ARTISTS, Ancestry.DIPLOMATS, Ancestry.REBORN };
            break;
        case JIN_MEI:
            result = new Ancestry[] { Ancestry.SANG_DO_CASTE, Ancestry.SAAN_GO_CASTE, Ancestry.JING_KO_CASTE };
            break;
        case AMARR:
            result = new Ancestry[] { Ancestry.LIBERAL_HOLDERS, Ancestry.WEALTHY_COMMONERS, Ancestry.RELIGIOUS_RECLAIMERS };
            break;
        case KHANID:
            result = new Ancestry[] { Ancestry.CYBER_KNIGHTS, Ancestry.UNIONISTS, Ancestry.ZEALOTS };
            break;
        case NI_KUNNI:
            result = new Ancestry[] { Ancestry.FREE_MERCHANTS, Ancestry.BORDER_RUNNERS, Ancestry.NAVY_VETERANS };
            break;
        case BRUTOR:
            result = new Ancestry[] { Ancestry.WORKERS, Ancestry.SLAVE_CHILD, Ancestry.TRIBAL_TRADITIONALISTS };
            break;
        case SEBIESTOR:
            result = new Ancestry[] { Ancestry.TRADERS, Ancestry.REBELS, Ancestry.TINKERERS };
            break;
        case VHEROKIOR:
            result = new Ancestry[] { Ancestry.RETAILERS, Ancestry.MYSTICS, Ancestry.DRIFTERS };
            break;
        default:
            break;
        }
        return result;
    }
}
