package com.beimin.eveapi.model.shared;

public enum Ancestry {
	DISSENTERS(Bloodline.CIVIRE), MERCS(Bloodline.CIVIRE), ENTREPRENEURS(Bloodline.CIVIRE), //
	TUBE_CHILD(Bloodline.DETEIS), SCIENTISTS(Bloodline.DETEIS), MERCHANDISERS(Bloodline.DETEIS), //
	INVENTORS(Bloodline.ACHURA), MONKS(Bloodline.ACHURA), STARGAZERS(Bloodline.ACHURA), //
	ACTIVISTS(Bloodline.GALLENTE), IMMIGRANTS(Bloodline.GALLENTE), MINERS(Bloodline.GALLENTE), //
	ARTISTS(Bloodline.INTAKI), DIPLOMATS(Bloodline.INTAKI), REBORN(Bloodline.INTAKI), //
	SANG_DO_CASTE(Bloodline.JIN_MEI), SAAN_GO_CASTE(Bloodline.JIN_MEI), JING_KO_CASTE(Bloodline.JIN_MEI), //
	LIBERAL_HOLDERS(Bloodline.AMARR), WEALTHY_COMMONERS(Bloodline.AMARR), RELIGIOUS_RECLAIMERS(Bloodline.AMARR), //
	CYBER_KNIGHTS(Bloodline.KHANID), UNIONISTS(Bloodline.KHANID), ZEALOTS(Bloodline.KHANID), //
	FREE_MERCHANTS(Bloodline.NI_KUNNI), BORDER_RUNNERS(Bloodline.NI_KUNNI), NAVY_VETERANS(Bloodline.NI_KUNNI), //
	WORKERS(Bloodline.BRUTOR), SLAVE_CHILD(Bloodline.BRUTOR), TRIBAL_TRADITIONALISTS(Bloodline.BRUTOR), //
	TRADERS(Bloodline.SEBIESTOR), REBELS(Bloodline.SEBIESTOR), TINKERERS(Bloodline.SEBIESTOR), //
	RETAILERS(Bloodline.VHEROKIOR), MYSTICS(Bloodline.VHEROKIOR), DRIFTERS(Bloodline.VHEROKIOR);
	private final Bloodline bloodline;

	private Ancestry(Bloodline bloodline) {
		this.bloodline = bloodline;
	}

	public Bloodline getBloodline() {
		return bloodline;
	}
}