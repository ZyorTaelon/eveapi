package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractStandingsParser;

public class CorpStandingsParser extends AbstractStandingsParser {
    public CorpStandingsParser() {
        super(ApiPath.CORPORATION);
    }
}
