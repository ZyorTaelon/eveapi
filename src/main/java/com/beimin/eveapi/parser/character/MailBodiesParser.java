package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.character.MailBodiesHandler;
import com.beimin.eveapi.model.character.MailBody;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.character.MailBodiesResponse;
import com.beimin.eveapi.utils.StringUtils;

public class MailBodiesParser extends AbstractListParser<MailBodiesHandler, MailBodiesResponse, MailBody> {
    public MailBodiesParser() {
        super(MailBodiesResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAIL_BODIES, MailBodiesHandler.class);
    }

    public MailBodiesResponse getResponse(final ApiAuth auth, final long... ids) throws ApiException {
        return getResponse(auth, "ids", StringUtils.join(",", ids));
    }
}
