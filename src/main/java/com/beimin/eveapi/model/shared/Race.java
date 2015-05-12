package com.beimin.eveapi.model.shared;

public enum Race {
	CALDARI(Bloodline.CIVIRE, Bloodline.DETEIS, Bloodline.ACHURA), //
	GALLENTE(Bloodline.GALLENTE, Bloodline.INTAKI, Bloodline.JIN_MEI), //
	AMARR(Bloodline.AMARR, Bloodline.KHANID, Bloodline.NI_KUNNI), //
	MINMATAR(Bloodline.BRUTOR, Bloodline.SEBIESTOR, Bloodline.VHEROKIOR), //
	JOVE;
	private final Bloodline[] bloodlines;

	private Race(Bloodline... bloodlines) {
		this.bloodlines = bloodlines;
	}

	public Bloodline[] getBloodlines() {
		return bloodlines;
	}
}