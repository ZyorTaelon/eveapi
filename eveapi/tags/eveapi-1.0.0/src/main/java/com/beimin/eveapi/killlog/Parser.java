package com.beimin.eveapi.killlog;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String KILL_LIST = "/KillList.xml.aspx";

	public Parser() {
		super(Response.class, 1, KILL_LIST);
	}

	public Response getKillList(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		if (corporation)
			return getResponse(auth, Path.CORP);
		return getResponse(auth, Path.CHARACTER);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiKill.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addObjectCreate("eveapi/result/rowset/row/victim", ApiKillVictim.class);
		digester.addSetProperties("eveapi/result/rowset/row/victim");
		digester.addSetNext("eveapi/result/rowset/row/victim", "setVictim");

		digester.addFactoryCreate("eveapi/result/rowset/row/rowset/row", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				if (attributes.getValue("characterID") != null)
					return new ApiKillAttacker();
				if (attributes.getValue("typeID") != null)
					return new ApiKillItem();
				return null;
			}
		});
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addKillDetail");
		digester.addSetNext("eveapi/result/rowset/row", "addKill");
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}