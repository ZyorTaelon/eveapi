package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractIndustryJobsParser;

public class IndustryJobsParser extends AbstractIndustryJobsParser {
	public IndustryJobsParser() {
		super(ApiPath.CORPORATION);
	}
}