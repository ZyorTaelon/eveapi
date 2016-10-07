package com.beimin.eveapi.model.shared;

public enum Race {
    CALDARI, GALLENTE, AMARR, MINMATAR, JOVE;

    public Bloodline[] getBloodlines() {
        Bloodline[] result = null;
        switch (this) {
        case CALDARI:
            result = new Bloodline[] { Bloodline.CIVIRE, Bloodline.DETEIS, Bloodline.ACHURA };
            break;
        case GALLENTE:
            result = new Bloodline[] { Bloodline.GALLENTE, Bloodline.INTAKI, Bloodline.JIN_MEI };
            break;
        case AMARR:
            result = new Bloodline[] { Bloodline.AMARR, Bloodline.KHANID, Bloodline.NI_KUNNI };
            break;
        case MINMATAR:
            result = new Bloodline[] { Bloodline.BRUTOR, Bloodline.SEBIESTOR, Bloodline.VHEROKIOR };
            break;
        default:
            break;
        }
        return result;
    }
}
