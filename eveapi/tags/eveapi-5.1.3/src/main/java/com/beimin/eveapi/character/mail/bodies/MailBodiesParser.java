package com.beimin.eveapi.character.mail.bodies;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.StringUtils;

public class MailBodiesParser extends AbstractListParser<MailBodiesHandler, MailBodiesResponse, ApiMailBody> {
	private MailBodiesParser() {
		super(MailBodiesResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAIL_BODIES, MailBodiesHandler.class);
	}

	public static MailBodiesParser getInstance() {
		return new MailBodiesParser();
	}

	public MailBodiesResponse getResponse(ApiAuth<?> auth, long... ids) throws ApiException {
		return getResponse(auth, "ids", StringUtils.join(",", ids));
	}
}