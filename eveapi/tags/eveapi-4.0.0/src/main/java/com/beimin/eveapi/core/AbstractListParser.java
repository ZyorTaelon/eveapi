package com.beimin.eveapi.core;

import org.apache.commons.digester.Digester;

public abstract class AbstractListParser<E extends ApiListResponse<B>, B> extends AbstractApiParser<E> {
	private final Class<B> itemClazz;

	public AbstractListParser(Class<E> clazz, int version, ApiPath path, ApiPage page, Class<B> itemClazz) {
		super(clazz, version, path, page);
		this.itemClazz = itemClazz;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", itemClazz);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	@Override
	protected E getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}

	@Override
	protected E getResponse() throws ApiException {
		return super.getResponse();
	}
}