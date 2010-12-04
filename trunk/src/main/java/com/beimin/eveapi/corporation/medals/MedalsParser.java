package com.beimin.eveapi.corporation.medals;

import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.medals.AbstractMedalsParser;

public class MedalsParser extends AbstractMedalsParser<CorpMedal> {
	private MedalsParser() {
		super(ApiPath.CORPORATION, CorpMedal.class);
	}

	public static MedalsParser getInstance() {
		return new MedalsParser();
	}
}