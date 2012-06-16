package com.beimin.eveapi.core;

public abstract class AbstractListParser<H extends AbstractContentListHandler<E, B>, E extends ApiListResponse<B>, B> extends AbstractApiParser<E> {
	private final Class<H> handlerClazz;

	public AbstractListParser(Class<E> clazz, int version, ApiPath path, ApiPage page, Class<H> handlerClazz) {
		super(clazz, version, path, page);
		this.handlerClazz = handlerClazz;
	}

	@Override
	protected final AbstractContentHandler getContentHandler() {
		try {
			return handlerClazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
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