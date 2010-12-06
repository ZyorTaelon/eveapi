package com.beimin.eveapi.character.mail.bodies;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.StringUtils;

public class MailBodiesParser extends AbstractApiParser<MailBodiesResponse> {
	private MailBodiesParser() {
		super(MailBodiesResponse.class, 2, ApiPath.CHARACTER, ApiPage.MAIL_BODIES);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiMailBody.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addBeanPropertySetter("eveapi/result/rowset/row", "body");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	public static MailBodiesParser getInstance() {
		return new MailBodiesParser();
	}

	public MailBodiesResponse getResponse(ApiAuth auth, long... ids) throws ApiException {
		return getResponse(auth, "ids", StringUtils.join(",", ids));
	}
}