package com.beimin.eveapi.shared.character;

public enum EveAncestry {
	DISSENTERS(EveBloodline.CIVIRE), MERCS(EveBloodline.CIVIRE), ENTREPRENEURS(EveBloodline.CIVIRE), //
	TUBE_CHILD(EveBloodline.DETEIS), SCIENTISTS(EveBloodline.DETEIS), MERCHANDISERS(EveBloodline.DETEIS), //
	INVENTORS(EveBloodline.ACHURA), MONKS(EveBloodline.ACHURA), STARGAZERS(EveBloodline.ACHURA), //
	ACTIVISTS(EveBloodline.GALLENTE), IMMIGRANTS(EveBloodline.GALLENTE), MINERS(EveBloodline.GALLENTE), //
	ARTISTS(EveBloodline.INTAKI), DIPLOMATS(EveBloodline.INTAKI), REBORN(EveBloodline.INTAKI), //
	SANG_DO_CASTE(EveBloodline.JIN_MEI), SAAN_GO_CASTE(EveBloodline.JIN_MEI), JING_KO_CASTE(EveBloodline.JIN_MEI), //
	LIBERAL_HOLDERS(EveBloodline.AMARR), WEALTHY_COMMONERS(EveBloodline.AMARR), RELIGIOUS_RECLAIMERS(EveBloodline.AMARR), //
	CYBER_KNIGHTS(EveBloodline.KHANID), UNIONISTS(EveBloodline.KHANID), ZEALOTS(EveBloodline.KHANID), //
	FREE_MERCHANTS(EveBloodline.NI_KUNNI), BORDER_RUNNERS(EveBloodline.NI_KUNNI), NAVY_VETERANS(EveBloodline.NI_KUNNI), //
	WORKERS(EveBloodline.BRUTOR), SLAVE_CHILD(EveBloodline.BRUTOR), TRIBAL_TRADITIONALISTS(EveBloodline.BRUTOR), //
	TRADERS(EveBloodline.SEBIESTOR), REBELS(EveBloodline.SEBIESTOR), TINKERERS(EveBloodline.SEBIESTOR), //
	RETAILERS(EveBloodline.VHEROKIOR), MYSTICS(EveBloodline.VHEROKIOR), DRIFTERS(EveBloodline.VHEROKIOR);
	private final EveBloodline bloodline;

	private EveAncestry(EveBloodline bloodline) {
		this.bloodline = bloodline;
	}

	public EveBloodline getBloodline() {
		return bloodline;
	}
}