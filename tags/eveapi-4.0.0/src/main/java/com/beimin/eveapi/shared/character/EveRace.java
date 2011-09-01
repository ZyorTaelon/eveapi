package com.beimin.eveapi.shared.character;

public enum EveRace {
	CALDARI(EveBloodline.CIVIRE, EveBloodline.DETEIS, EveBloodline.ACHURA), //
	GALLENTE(EveBloodline.GALLENTE, EveBloodline.INTAKI, EveBloodline.JIN_MEI), //
	AMARR(EveBloodline.AMARR, EveBloodline.KHANID, EveBloodline.NI_KUNNI), //
	MINMATAR(EveBloodline.BRUTOR, EveBloodline.SEBIESTOR, EveBloodline.VHEROKIOR), //
	JOVE;
	private final EveBloodline[] bloodlines;

	private EveRace(EveBloodline... bloodlines) {
		this.bloodlines = bloodlines;
	}

	public EveBloodline[] getBloodlines() {
		return bloodlines;
	}
}