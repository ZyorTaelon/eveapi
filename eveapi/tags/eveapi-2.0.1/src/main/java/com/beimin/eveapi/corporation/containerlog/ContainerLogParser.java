package com.beimin.eveapi.corporation.containerlog;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class ContainerLogParser extends AbstractApiParser<ContainerLogResponse> {
	protected static final String CONTAINER_LOG_URL = "/corp/ContainerLog.xml.aspx ";

	public ContainerLogParser() {
		super(ContainerLogResponse.class, 2, CONTAINER_LOG_URL);
	}

	public ContainerLogResponse getContainerLog(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
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
}