package com.beimin.eveapi.character.industryjobs;

import com.beimin.eveapi.shared.industryjobs.AbstractIndustryJobsParser;

public class IndustryJobsParser extends AbstractIndustryJobsParser {

	private IndustryJobsParser() {
		super(Path.CHARACTER);
	}

	public static IndustryJobsParser getInstance() {
		return new IndustryJobsParser();
	}
}