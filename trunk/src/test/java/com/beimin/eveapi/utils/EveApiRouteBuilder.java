package com.beimin.eveapi.utils;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class EveApiRouteBuilder extends RouteBuilder implements Processor, ExchangeProcessor.ExtraAsserts {

	@Override
	public void configure() {
		addRoute(ApiPath.ACCOUNT, ApiPage.ACCOUNT_STATUS);
		addRoute(ApiPath.ACCOUNT, ApiPage.CHARACTERS);
		addRoute(ApiPath.CHARACTER, ApiPage.ACCOUNT_BALANCE);
	}

	private void addRoute(ApiPath path, ApiPage page) {
		final String resPath = path.getPath() + "/" + page.getPage();
		from("jetty:" + MockApi.URL + resPath + ".xml.aspx").process(new ExchangeProcessor(EveApiRouteBuilder.this, resPath + ".xml")).end();
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		String body = exchange.getIn().getBody(String.class);
		Map<String, String> params = CamelUtils.parsePostParams(body);
		assertNotNull(params);
	}

	@Override
	public void extraAsserts(Map<String, String> params) {
		// TODO Auto-generated method stub
	}
}