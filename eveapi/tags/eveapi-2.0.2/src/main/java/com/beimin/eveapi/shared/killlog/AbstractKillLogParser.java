package com.beimin.eveapi.shared.killlog;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractKillLogParser extends AbstractApiParser<KillLogResponse> {
	protected static final String KILL_LIST = "/KillLog.xml.aspx";
	private final Path path;

	protected AbstractKillLogParser(Path path) {
		super(KillLogResponse.class, 1, KILL_LIST);
		this.path = path;
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

	public KillLogResponse getKillLogResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, path);
	}

	public Collection<ApiKill> getKills(ApiAuth auth) throws IOException, SAXException {
		return getKillLogResponse(auth).getKills();
	}
}