package com.beimin.eveapi.corporation.industryjobs;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.industryjobs.AbstractIndustryJobsParser;

public class CorporationIndustryJobsParser extends AbstractIndustryJobsParser {
	public CorporationIndustryJobsParser() {
		super(ApiPath.CORPORATION);
	}
}