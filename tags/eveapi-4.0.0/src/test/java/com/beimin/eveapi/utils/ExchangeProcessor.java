package com.beimin.eveapi.utils;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author Candle
 */
public class ExchangeProcessor implements Processor {

	public interface ExtraAsserts {

		void extraAsserts(Map<String, String> params);
	}
	ExtraAsserts extras;
	String fullPath;

	public ExchangeProcessor(ExtraAsserts extras, String fullPath) {
		this.extras = extras;
		this.fullPath = fullPath;
	}

	@Override
	public void process(Exchange exchange) {
		String s = exchange.getIn().getBody(String.class);
		Map<String, String> params = CamelUtils.parsePostParams(s);
		assertNotNull(params);
		extras.extraAsserts(params);
		exchange.getOut().setBody(MockApi.response(fullPath));
	}
}
