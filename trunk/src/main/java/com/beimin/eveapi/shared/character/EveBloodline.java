package com.beimin.eveapi.shared.character;

public enum EveBloodline {
	CIVIRE(EveRace.CALDARI), DETEIS(EveRace.CALDARI), ACHURA(EveRace.CALDARI), //
	GALLENTE(EveRace.GALLENTE), INTAKI(EveRace.GALLENTE), JIN_MEI(EveRace.GALLENTE), //
	AMARR(EveRace.AMARR), KHANID(EveRace.AMARR), NI_KUNNI(EveRace.AMARR), //
	BRUTOR(EveRace.MINMATAR), SEBIESTOR(EveRace.MINMATAR), VHEROKIOR(EveRace.MINMATAR);
	private final EveRace race;

	EveBloodline(EveRace race) {
		this.race = race;
	}

	public EveRace getRace() {
		return race;
	}
}