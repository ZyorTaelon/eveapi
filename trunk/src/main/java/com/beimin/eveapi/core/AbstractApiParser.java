package com.beimin.eveapi.core;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.digester.Digester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beimin.eveapi.EveApi;
import com.beimin.eveapi.shared.character.EveAncestry;
import com.beimin.eveapi.shared.character.EveAncestryConverter;
import com.beimin.eveapi.shared.character.EveBloodline;
import com.beimin.eveapi.shared.character.EveBloodlineConverter;
import com.beimin.eveapi.shared.character.EveRace;
import com.beimin.eveapi.shared.character.EveRaceConverter;
import com.beimin.eveapi.utils.DateUtils;

public abstract class AbstractApiParser<E extends ApiResponse> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	protected final ApiPath path;
	protected final ApiPage page;
	protected final int version;
	protected final Class<E> clazz;

	public AbstractApiParser(Class<E> clazz, int version, ApiPath path, ApiPage page) {
		this.clazz = clazz;
		this.version = version;
		this.path = path;
		this.page = page;
	}

	protected Digester getDigester() {
		Digester digester = new Digester();
		ConvertUtils.register(DateUtils.getGMTConverter(), Date.class);
		ConvertUtils.register(new EveRaceConverter(), EveRace.class);
		ConvertUtils.register(new EveBloodlineConverter(), EveBloodline.class);
		ConvertUtils.register(new EveAncestryConverter(), EveAncestry.class);
		digester.setValidating(false);
		digester.addObjectCreate("eveapi", clazz);
		digester.addSetProperties("eveapi");
		digester.addObjectCreate("eveapi/error", ApiError.class);
		digester.addSetProperties("eveapi/error");
		digester.addBeanPropertySetter("eveapi/error");
		digester.addSetNext("eveapi/error", "setError");
		digester.addBeanPropertySetter("eveapi/currentTime");
		digester.addBeanPropertySetter("eveapi/cachedUntil");
		return digester;
	}

	protected E getResponse() throws ApiException {
		return getResponse(new ApiRequest(path, page, version));
	}

	protected E getResponse(ApiAuth auth) throws ApiException {
		return getResponse(new ApiRequest(path, page, version, auth));
	}

	protected E getResponse(ApiAuth auth, String paramName, String paramValue) throws ApiException {
		return getResponse(new ApiRequest(path, page, version, auth, Collections.singletonMap(paramName, paramValue)));
	}

	protected E getResponse(ApiAuth auth, Map<String, String> extraParams) throws ApiException {
		return getResponse(new ApiRequest(path, page, version, auth, extraParams));
	}

	protected E getResponse(String paramName, String paramValue) throws ApiException {
		return getResponse(new ApiRequest(path, page, version, Collections.singletonMap(paramName, paramValue)));
	}

	private E getResponse(ApiRequest request) throws ApiException {
		return EveApi.getConnector().execute(request, getDigester(), clazz);
	}
}