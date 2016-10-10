package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractIndustryJobsParser;

public class CharIndustryJobsParser extends AbstractIndustryJobsParser {
    public CharIndustryJobsParser() {
        super(ApiPath.CHARACTER);
    }
}
