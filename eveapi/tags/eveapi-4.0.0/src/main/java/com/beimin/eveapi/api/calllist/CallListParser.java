package com.beimin.eveapi.api.calllist;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.xml.sax.Attributes;

public class CallListParser extends AbstractApiParser<CallListResponse> {
	public CallListParser() {
		super(CallListResponse.class, 2, ApiPath.NONE, ApiPage.CALL_LIST);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result", CallList.class);

		digester.addFactoryCreate("eveapi/result/rowset/row", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				if (attributes.getValue("accessMask") != null) {
					return new Call();
				} else {
					return new CallGroup();
				}
			}
		});
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		digester.addSetNext("eveapi/result", "set");

		return digester;
	}

	public static CallListParser getInstance() {
		return new CallListParser();
	}

	@Override
	public CallListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}