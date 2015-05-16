package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.ApiListResponse;

public abstract class AbstractListParser<H extends AbstractContentListHandler<E, B>, E extends ApiListResponse<B>, B> extends AbstractApiParser<E> {
    private final Class<H> handlerClazz;

    public AbstractListParser(final Class<E> clazz, final int version, final ApiPath path, final ApiPage page, final Class<H> handlerClazz) {
	super(clazz, version, path, page);
	this.handlerClazz = handlerClazz;
    }

    @Override
    protected final AbstractContentHandler getContentHandler() {
	try {
	    return handlerClazz.newInstance();
	} catch (final InstantiationException e) {
	    e.printStackTrace();
	} catch (final IllegalAccessException e) {
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    public E getResponse(final ApiAuth auth) throws ApiException {
	return super.getResponse(auth);
    }

    @Override
    protected E getResponse() throws ApiException {
	return super.getResponse();
    }
}