package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractAssetListParser;

public class CorpAssetListParser extends AbstractAssetListParser {
    public CorpAssetListParser() {
        super(ApiPath.CORPORATION);
    }
}
