package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.corporation.ContainerLogHandler;
import com.beimin.eveapi.model.corporation.ContainerLog;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.corporation.ContainerLogResponse;

public class ContainerLogParser extends AbstractListParser<ContainerLogHandler, ContainerLogResponse, ContainerLog> {
	public ContainerLogParser() {
		super(ContainerLogResponse.class, 2, ApiPath.CORPORATION, ApiPage.CONTAINER_LOG, ContainerLogHandler.class);
	}

	@Override
	public ContainerLogResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}