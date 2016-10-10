package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractKillMailParser;

public class CharKillMailParser extends AbstractKillMailParser {
    public CharKillMailParser() {
        super(ApiPath.CHARACTER);
    }
}
