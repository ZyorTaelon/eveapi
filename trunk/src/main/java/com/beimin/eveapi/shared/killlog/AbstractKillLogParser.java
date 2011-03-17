package com.beimin.eveapi.shared.killlog;


import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractKillLogParser extends AbstractApiParser<KillLogResponse> {
	protected AbstractKillLogParser(ApiPath path) {
		super(KillLogResponse.class, 1, path, ApiPage.KILL_LOG);
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

	@Override
	public KillLogResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}