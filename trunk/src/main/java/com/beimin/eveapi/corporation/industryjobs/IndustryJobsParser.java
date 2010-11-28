package com.beimin.eveapi.corporation.industryjobs;

import com.beimin.eveapi.shared.industryjobs.AbstractIndustryJobsParser;

public class IndustryJobsParser extends AbstractIndustryJobsParser {

	private IndustryJobsParser() {
		super(Path.CORPORATION);
	}

	public static IndustryJobsParser getInstance() {
		return new IndustryJobsParser();
	}
}