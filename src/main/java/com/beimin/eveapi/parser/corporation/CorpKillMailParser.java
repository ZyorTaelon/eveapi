package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractKillMailParser;

public class CorpKillMailParser extends AbstractKillMailParser {
    public CorpKillMailParser() {
        super(ApiPath.CORPORATION);
    }
}
