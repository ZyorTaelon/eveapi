package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.pilot.MailBodiesHandler;
import com.beimin.eveapi.model.pilot.MailBody;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.pilot.MailBodiesResponse;
import com.beimin.eveapi.utils.StringUtils;

public class MailBodiesParser extends AbstractListParser<MailBodiesHandler, MailBodiesResponse, MailBody> {
	public MailBodiesParser() {
		super(MailBodiesResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAIL_BODIES, MailBodiesHandler.class);
	}

	public MailBodiesResponse getResponse(ApiAuth<?> auth, long... ids) throws ApiException {
		return getResponse(auth, "ids", StringUtils.join(",", ids));
	}
}