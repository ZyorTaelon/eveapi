package com.beimin.eveapi.model.shared;

public enum Bloodline {
	CIVIRE(Race.CALDARI, Ancestry.DISSENTERS, Ancestry.MERCS, Ancestry.ENTREPRENEURS), //
	DETEIS(Race.CALDARI, Ancestry.TUBE_CHILD, Ancestry.SCIENTISTS, Ancestry.MERCHANDISERS), //
	ACHURA(Race.CALDARI, Ancestry.INVENTORS, Ancestry.MONKS, Ancestry.STARGAZERS), //
	GALLENTE(Race.GALLENTE, Ancestry.ACTIVISTS, Ancestry.IMMIGRANTS, Ancestry.MINERS), //
	INTAKI(Race.GALLENTE, Ancestry.ARTISTS, Ancestry.DIPLOMATS, Ancestry.REBORN), //
	JIN_MEI(Race.GALLENTE, Ancestry.SANG_DO_CASTE, Ancestry.SAAN_GO_CASTE, Ancestry.JING_KO_CASTE), //
	AMARR(Race.AMARR, Ancestry.LIBERAL_HOLDERS, Ancestry.WEALTHY_COMMONERS, Ancestry.RELIGIOUS_RECLAIMERS), //
	KHANID(Race.AMARR, Ancestry.CYBER_KNIGHTS, Ancestry.UNIONISTS, Ancestry.ZEALOTS), //
	NI_KUNNI(Race.AMARR, Ancestry.FREE_MERCHANTS, Ancestry.BORDER_RUNNERS, Ancestry.NAVY_VETERANS), //
	BRUTOR(Race.MINMATAR, Ancestry.WORKERS, Ancestry.SLAVE_CHILD, Ancestry.TRIBAL_TRADITIONALISTS), //
	SEBIESTOR(Race.MINMATAR, Ancestry.TRADERS, Ancestry.REBELS, Ancestry.TINKERERS), //
	VHEROKIOR(Race.MINMATAR, Ancestry.RETAILERS, Ancestry.MYSTICS, Ancestry.DRIFTERS);
	private final Race race;
	private final Ancestry[] ancestries;

	Bloodline(Race race, Ancestry... ancestries) {
		this.race = race;
		this.ancestries = ancestries;
	}

	public Race getRace() {
		return race;
	}

	public Ancestry[] getAncestries() {
		return ancestries;
	}
}