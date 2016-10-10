package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractIndustryJobsParser;

public class CorpIndustryJobsParser extends AbstractIndustryJobsParser {
    public CorpIndustryJobsParser() {
        super(ApiPath.CORPORATION);
    }
}
