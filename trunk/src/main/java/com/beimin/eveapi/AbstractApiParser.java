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
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.digester.Digester;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

public abstract class AbstractApiParser<E extends ApiResponse> {
	protected enum Path {
		CORP("/corp"), CHARACTER("/char"), NONE("");
		private final String path;

		Path(String path) {
			this.path = path;
		}

		public String getPath() {
			return path;
		}
	};

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

	protected static final String CORP_PATH = "/corp";
	protected static final String CHAR_PATH = "/char";
	private final Class<E> clazz;
	private final int apiVersion;
	protected final Map<String, E> cache = new HashMap<String, E>();
	private final String pageURL;
	private boolean cachingEnabled = false;
	private boolean serializeCaching = false;

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

	public AbstractApiParser(Class<E> clazz, int apiVersion, String pageURL) {
		this.clazz = clazz;
		this.apiVersion = apiVersion;
		this.pageURL = pageURL;
		deSerializeCache();
	}

	protected Digester getDigester() {
		Digester digester = new Digester();
		DateLocaleConverter converter = new DateLocaleConverter(Locale.getDefault(), "yyyy-MM-dd HH:mm:ss");
		converter.setLenient(true);
		ConvertUtils.register(converter, java.util.Date.class);
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
			Date now = Calendar.getInstance().getTime();
			return cachedUntil.after(now);
		}
		return false;
	}

	private String getRequestUrl(ApiAuth auth, Path path, String pageURL, Map<String, String> extraParams) throws UnsupportedEncodingException {
		String requestUrl = eveApiURL;
		requestUrl += path.getPath();
		requestUrl += pageURL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=" + apiVersion;
		if (extraParams != null) {
			for (Entry<String, String> entry : extraParams.entrySet()) {
				requestUrl += "&" + entry.getKey() + "=" + entry.getValue();
			}
		}
		return requestUrl;
	}

	protected E getResponse(ApiAuth auth, Path path, Map<String, String> extraParams) throws IOException, SAXException {
		return getResponse(getRequestUrl(auth, path, pageURL, extraParams));
	}

	protected E getResponse(ApiAuth auth, Path path) throws IOException, SAXException {
		return getResponse(getRequestUrl(auth, path, pageURL, null));
	}

	protected E getResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(getRequestUrl(auth, Path.NONE, pageURL, null));
	}

	protected E getResponse(ApiAuth auth, Map<String, String> extraParams) throws IOException, SAXException {
		return getResponse(getRequestUrl(auth, Path.NONE, pageURL, extraParams));
	}

	protected E getResponse(Map<String, String> extraParams) throws IOException, SAXException {
		String requestUrl = eveApiURL + pageURL;
		boolean first = true;
		for (Entry<String, String> entry : extraParams.entrySet()) {
			if (first)
				requestUrl += "?";
			else
				requestUrl += "&";
			requestUrl += entry.getKey() + "=" + entry.getValue();
			first = false;
		}
		return getResponse(requestUrl);
	}

	protected E getResponse(String paramName, String paramValue) throws IOException, SAXException {
		return getResponse(eveApiURL + pageURL + "?" + paramName + "=" + paramValue);
	}

	protected E getResponse() throws IOException, SAXException {
		return getResponse(eveApiURL + pageURL);
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
