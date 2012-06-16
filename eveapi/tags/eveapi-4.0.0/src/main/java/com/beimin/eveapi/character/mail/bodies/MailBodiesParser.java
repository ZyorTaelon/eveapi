package com.beimin.eveapi.character.mail.bodies;


import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.StringUtils;

public class MailBodiesParser extends AbstractListParser<MailBodiesResponse, ApiMailBody> {
	private MailBodiesParser() {
		super(MailBodiesResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAIL_BODIES, ApiMailBody.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/rowset/row", "body");
		return digester;
	}

	public static MailBodiesParser getInstance() {
		return new MailBodiesParser();
	}

	public MailBodiesResponse getResponse(ApiAuth<?> auth, long... ids) throws ApiException {
		return getResponse(auth, "ids", StringUtils.join(",", ids));
	}
}