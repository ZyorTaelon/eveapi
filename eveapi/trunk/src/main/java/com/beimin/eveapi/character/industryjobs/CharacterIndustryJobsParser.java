package com.beimin.eveapi.character.industryjobs;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.industryjobs.AbstractIndustryJobsParser;

public class CharacterIndustryJobsParser extends AbstractIndustryJobsParser {
	public CharacterIndustryJobsParser() {
		super(ApiPath.CHARACTER);
	}
}