package com.beimin.eveapi.shared.character;

public enum EveBloodline {
	CIVIRE(EveRace.CALDARI, EveAncestry.DISSENTERS, EveAncestry.MERCS, EveAncestry.ENTREPRENEURS), //
	DETEIS(EveRace.CALDARI, EveAncestry.TUBE_CHILD, EveAncestry.SCIENTISTS, EveAncestry.MERCHANDISERS), //
	ACHURA(EveRace.CALDARI, EveAncestry.INVENTORS, EveAncestry.MONKS, EveAncestry.STARGAZERS), //
	GALLENTE(EveRace.GALLENTE, EveAncestry.ACTIVISTS, EveAncestry.IMMIGRANTS, EveAncestry.MINERS), //
	INTAKI(EveRace.GALLENTE, EveAncestry.ARTISTS, EveAncestry.DIPLOMATS, EveAncestry.REBORN), //
	JIN_MEI(EveRace.GALLENTE, EveAncestry.SANG_DO_CASTE, EveAncestry.SAAN_GO_CASTE, EveAncestry.JING_KO_CASTE), //
	AMARR(EveRace.AMARR, EveAncestry.LIBERAL_HOLDERS, EveAncestry.WEALTHY_COMMONERS, EveAncestry.RELIGIOUS_RECLAIMERS), //
	KHANID(EveRace.AMARR, EveAncestry.CYBER_KNIGHTS, EveAncestry.UNIONISTS, EveAncestry.ZEALOTS), //
	NI_KUNNI(EveRace.AMARR, EveAncestry.FREE_MERCHANTS, EveAncestry.BORDER_RUNNERS, EveAncestry.NAVY_VETERANS), //
	BRUTOR(EveRace.MINMATAR, EveAncestry.WORKERS, EveAncestry.SLAVE_CHILD, EveAncestry.TRIBAL_TRADITIONALISTS), //
	SEBIESTOR(EveRace.MINMATAR, EveAncestry.TRADERS, EveAncestry.REBELS, EveAncestry.TINKERERS), //
	VHEROKIOR(EveRace.MINMATAR, EveAncestry.RETAILERS, EveAncestry.MYSTICS, EveAncestry.DRIFTERS);
	private final EveRace race;
	private final EveAncestry[] ancestries;

	EveBloodline(EveRace race, EveAncestry... ancestries) {
		this.race = race;
		this.ancestries = ancestries;
	}

	public EveRace getRace() {
		return race;
	}

	public EveAncestry[] getAncestries() {
		return ancestries;
	}
}