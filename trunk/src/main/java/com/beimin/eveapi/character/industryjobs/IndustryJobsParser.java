package com.beimin.eveapi.character.industryjobs;

import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.industryjobs.AbstractIndustryJobsParser;

public class IndustryJobsParser extends AbstractIndustryJobsParser {
	private IndustryJobsParser() {
		super(ApiPath.CHARACTER);
	}

	public static IndustryJobsParser getInstance() {
		return new IndustryJobsParser();
	}
}