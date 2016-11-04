package com.beimin.eveapi.parser.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.shared.ContactListHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public abstract class AbstractContactListParser<CLR extends AbstractContactListResponse> extends AbstractApiParser<CLR> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractContactListParser.class);

    protected AbstractContactListParser(final Class<CLR> responseClass, final ApiPath path) {
        super(responseClass, 2, path, ApiPage.CONTACT_LIST);
    }

    @Override
    protected AbstractContentHandler<CLR> getContentHandler() {
        try {
            return new ContactListHandler<CLR>(clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("Couldn't create response", e);
            return null;
        }
    }

    @Override
    public CLR getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
