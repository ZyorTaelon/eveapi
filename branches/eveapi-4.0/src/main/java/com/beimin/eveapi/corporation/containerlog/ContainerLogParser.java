package com.beimin.eveapi.corporation.containerlog;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ContainerLogParser extends AbstractListParser<ContainerLogResponse, ApiContainerLog> {
	public ContainerLogParser() {
		super(ContainerLogResponse.class, 2, ApiPath.CORPORATION, ApiPage.CONTAINER_LOG, ApiContainerLog.class);
	}

	public static ContainerLogParser getInstance() {
		return new ContainerLogParser();
	}

	@Override
	public ContainerLogResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}