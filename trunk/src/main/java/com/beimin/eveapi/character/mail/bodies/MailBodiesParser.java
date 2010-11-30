package com.beimin.eveapi.character.mail.bodies;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class MailBodiesParser extends AbstractApiParser<MailBodiesResponse> {
	private static final String MAIL_MESSAGES_URL = "/MailBodies";

	private MailBodiesParser() {
		super(MailBodiesResponse.class, 2, Path.CHARACTER, MAIL_MESSAGES_URL);
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

	public MailBodiesResponse getMailBodiesResponse(ApiAuth auth, long... ids) throws IOException, SAXException {
		StringBuilder idString = new StringBuilder();
		for (int i = 0; i < ids.length; i++) {
			idString.append(ids[i]);
			if (i < ids.length - 1)
				idString.append(",");
		}
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("ids", idString.toString());
		return getResponse(auth, extraParams);
	}

	public Set<ApiMailBody> getMailBodies(ApiAuth auth, long... ids) throws IOException, SAXException {
		return getMailBodiesResponse(auth, ids).getMailBodies();
	}

	public static MailBodiesParser getInstance() {
		return new MailBodiesParser();
	}
}