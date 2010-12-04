package com.beimin.eveapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.digester.Digester;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.beimin.eveapi.utils.DateUtils;

public abstract class AbstractApiParser<E extends ApiResponse> {
	private final String filename = "cacheFile.ser";

	protected Logger logger = Logger.getLogger(getClass());

	protected static final String DEFAULT_EVE_API_URL = "http://api.eve-online.com";
	/*
	 * these two are static because there is no particular reason why they
	 * should be instance-based; If you are using an http proxy for one, then
	 * the chances are you are using the http proxy for all.
	 * 
	 * The same applies to the eveApiURL; this can be changed so that you use an
	 * api proxy.
	 */
	protected static String eveApiURL = "http://api.eve-online.com";
	protected static Proxy httpProxy = null;

	private final Class<E> clazz;
	private final int apiVersion;
	protected final Map<String, E> cache = new HashMap<String, E>();
	private boolean cachingEnabled = false;
	private boolean serializeCaching = false;

	protected final ApiPath path;
	private final ApiPage page;

	/**
	 * 
	 * @return the API url that is currently being used.
	 */
	public static String getEveApiURL() {
		return eveApiURL;
	}

	/**
	 * 
	 * @return the default API URL.
	 */
	public static String getDefaultApiUrl() {
		return DEFAULT_EVE_API_URL;
	}

	/**
	 * Sets the base URL that all API requests go to. This will be useful:
	 * <ul>
	 * <li>If CCP ever deploy an API server for the test server</li>
	 * <li>If you want to use one of the 3rd party API proxies (gatecamper, etc)
	 * </li>
	 * </ul>
	 * 
	 * @param apiURL
	 *            pass null to reset the eve api URL to the default:
	 *            "http://api.eve-online.com"
	 */
	public static void setEveApiURL(String apiURL) {
		if (apiURL == null) {
			eveApiURL = DEFAULT_EVE_API_URL;
		} else {
			eveApiURL = apiURL;
		}
	}

	/**
	 * gets the Proxy that is being used to connect to the API server.
	 * 
	 * @return
	 */
	public static Proxy getHttpProxy() {
		return httpProxy;
	}

	/**
	 * sets a HTTP Proxy for the API requests to go through.
	 * 
	 * @param httpProxy
	 */
	public static void setHttpProxy(Proxy httpProxy) {
		AbstractApiParser.httpProxy = httpProxy;
	}

	public AbstractApiParser(Class<E> clazz, int apiVersion, ApiPath path, ApiPage page) {
		this.clazz = clazz;
		this.apiVersion = apiVersion;
		this.path = path;
		this.page = page;
		deSerializeCache();
	}

	protected Digester getDigester() {
		Digester digester = new Digester();
		ConvertUtils.register(DateUtils.getGMTConverter(), java.util.Date.class);
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

	protected boolean isCached(String requestUrl) {
		boolean containsKey = cache.containsKey(requestUrl);
		if (containsKey) {
			E cachedResponse = cache.get(requestUrl);
			Date cachedUntil = cachedResponse.getCachedUntil();
			return cachedUntil.after(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
		}
		return false;
	}

	private String buildRequestUrl(ApiAuth auth, Map<String, String> extraParams) throws UnsupportedEncodingException {
		StringBuilder requestUrl = new StringBuilder(eveApiURL);
		requestUrl.append(path.getPath());
		requestUrl.append("/").append(page.getPage());
		requestUrl.append(".xml.aspx");
		requestUrl.append("?version=" + apiVersion);
		Map<String, String> params = new HashMap<String, String>();
		if (auth != null)
			params.putAll(auth.getParams());
		if (extraParams != null) {
			params.putAll(extraParams);
		}
		for (Entry<String, String> entry : params.entrySet()) {
			requestUrl.append("&" + entry.getKey() + "=" + entry.getValue());
		}
		return requestUrl.toString();
	}

	protected E getResponse() throws IOException, SAXException {
		return getResponse(buildRequestUrl(null, null));
	}

	protected E getResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(buildRequestUrl(auth, null));
	}

	protected E getResponse(ApiAuth auth, String paramName, String paramValue) throws IOException, SAXException {
		return getResponse(buildRequestUrl(auth, Collections.singletonMap(paramName, paramValue)));
	}

	protected E getResponse(ApiAuth auth, Map<String, String> extraParams) throws IOException, SAXException {
		return getResponse(buildRequestUrl(auth, extraParams));
	}

	protected E getResponse(Map<String, String> extraParams) throws IOException, SAXException {
		return getResponse(buildRequestUrl(null, extraParams));
	}

	protected E getResponse(String paramName, String paramValue) throws IOException, SAXException {
		return getResponse(Collections.singletonMap(paramName, paramValue));
	}

	private E getResponse(String requestUrl) throws IOException, SAXException {
		return getResponse(requestUrl, getDigester());
	}

	@SuppressWarnings("unchecked")
	private E getResponse(String requestUrl, Digester digester) throws IOException, SAXException {
		if (logger.isDebugEnabled())
			logger.debug(requestUrl);
		if (isCachingEnabled() && isCached(requestUrl)) {
			return cache.get(requestUrl);
		}
		E response = null;
		if (getHttpProxy() == null) {
			// no proxy, we can let the digester handle the dirty bits.
			response = (E) digester.parse(requestUrl);
		} else {
			// use the proxy - we pass the digester an input stream from which
			// it can read the XML.
			URLConnection urlCon = new URL(requestUrl).openConnection(getHttpProxy());
			urlCon.setDoInput(true);
			response = (E) digester.parse(urlCon.getInputStream());
		}
		if (isCachingEnabled() && !response.hasError()) {
			cache.put(requestUrl, response);
			serializeCache();
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	public E getResponse(InputStream input) throws IOException, SAXException {
		Digester digester = getDigester();
		E response = (E) digester.parse(input);
		return response;
	}

	private void serializeCache() {
		if (!(isCachingEnabled() && isSerializeCaching()))
			return;
		try {
			FileOutputStream fos = new FileOutputStream(getCacheFile());
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(cache);
			out.close();
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private void deSerializeCache() {
		if (!(isCachingEnabled() && isSerializeCaching()))
			return;
		try {
			File cacheFile = getCacheFile();
			if (!(cacheFile.exists() && cacheFile.canRead()))
				return;
			FileInputStream fis = new FileInputStream(cacheFile);
			ObjectInputStream in = new ObjectInputStream(fis);
			try {
				Map<String, E> oldCache = (Map<String, E>) in.readObject();
				cache.putAll(oldCache);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			in.close();
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
	}

	private File getCacheFile() {
		String tmpFilePath = System.getProperty("java.io.tmpdir");
		String cacheFilename = clazz.getCanonicalName() + "_" + filename;
		return new File(tmpFilePath, cacheFilename);
	}

	public boolean isCachingEnabled() {
		return cachingEnabled;
	}

	public void setCachingEnabled(boolean cachingEnabled) {
		this.cachingEnabled = cachingEnabled;
	}

	public boolean isSerializeCaching() {
		return serializeCaching;
	}

	public void setSerializeCaching(boolean serializeCaching) {
		this.serializeCaching = serializeCaching;
	}
}
