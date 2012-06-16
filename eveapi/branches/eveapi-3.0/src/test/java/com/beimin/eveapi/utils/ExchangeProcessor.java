package com.beimin.eveapi.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import static org.junit.Assert.*;

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
		Map<String, String> params = parsePostParams(s);
		assertNotNull(params);
		extras.extraAsserts(params);
		exchange.getOut().setBody(MockApi.response(fullPath));
	}

	/**
	 * Work-around for bug described in: 
	 * http://mail-archives.apache.org/mod_mbox/camel-users/201010.mbox/%3c4CC94149.8000800@catify.com
	 * 
	 * Note that the issue is not resolved in camel 2.6.0, so the version has not been changed from 2.5.0.
	 * 
	 * @param in
	 * @return a map of POST parameters.
	 */
	private static Map<String, String> parsePostParams(String in) {
		Map<String, String> postParams = new HashMap<String, String>();

		for (String kvs : in.split("&")) {
			String[] kv = kvs.split("=");
			if (kv.length == 2) {
				try {
					postParams.put(
							URLDecoder.decode(kv[0], "UTF-8"),
							URLDecoder.decode(kv[1], "UTF-8")
							);
				} catch (UnsupportedEncodingException mue) {
					throw new RuntimeException(mue);
				}
			}
		}

		return postParams;
	}
}
