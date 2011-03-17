package com.beimin.eveapi.shared.medals;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractMedalsParser<M extends Medal> extends AbstractApiParser<MedalsResponse> {
	private final Class<M> medalClass;

	protected AbstractMedalsParser(ApiPath path, Class<M> medalClass) {
		super(MedalsResponse.class, 2, path, ApiPage.MEDALS);
		this.medalClass = medalClass;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", medalClass);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMedal");
		return digester;
	}

	@Override
	public MedalsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}