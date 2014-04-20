package com.beimin.eveapi.corporation.containerlog;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class ContainerLogParser extends AbstractListParser<ContainerLogHandler, ContainerLogResponse, ApiContainerLog> {
	public ContainerLogParser() {
		super(ContainerLogResponse.class, 2, ApiPath.CORPORATION, ApiPage.CONTAINER_LOG, ContainerLogHandler.class);
	}

	@Override
	public ContainerLogResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}