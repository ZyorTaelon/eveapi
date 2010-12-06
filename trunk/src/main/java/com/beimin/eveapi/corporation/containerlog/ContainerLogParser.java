package com.beimin.eveapi.corporation.containerlog;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class ContainerLogParser extends AbstractApiParser<ContainerLogResponse> {
	public ContainerLogParser() {
		super(ContainerLogResponse.class, 2, ApiPath.CORPORATION, ApiPage.CONTAINER_LOG);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiContainerLog.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addContainerLog");
		return digester;
	}

	public static ContainerLogParser getInstance() {
		return new ContainerLogParser();
	}

	@Override
	public ContainerLogResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}