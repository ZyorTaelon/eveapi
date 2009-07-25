package com.beimin.eveapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
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
	protected static final String EVE_API_URL = "http://api.eve-online.com";
	protected static final String CORP_PATH = "/corp";
	protected static final String CHAR_PATH = "/char";
	private final Class<E> clazz;
	private final int apiVersion;
	protected final Map<String, E> cache = new HashMap<String, E>();
	private final String pageURL;
	private boolean cachingEnabled = false;
	private boolean serializeCaching = false;

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

	private String getRequestUrl(ApiAuth auth, String pageURL) throws UnsupportedEncodingException {
		return getRequestUrl(auth, Path.NONE, pageURL);
	}

	private String getRequestUrl(ApiAuth auth, Path path, String pageURL) throws UnsupportedEncodingException {
		String requestUrl = EVE_API_URL;
		requestUrl += path.getPath();
		requestUrl += pageURL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=" + apiVersion;
		return requestUrl;
	}

	protected E getResponse(ApiAuth auth, Path path) throws IOException, SAXException {
		return getResponse(getRequestUrl(auth, path, pageURL));
	}

	protected E getResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(getRequestUrl(auth, pageURL));
	}

	protected E getResponse(ApiAuth auth, Map<String, String> extraParams) throws IOException, SAXException {
		String requestUrl = getRequestUrl(auth, pageURL);
		for (Entry<String, String> entry : extraParams.entrySet()) {
			requestUrl += "&" + entry.getKey() + "=" + entry.getValue();
		}
		return getResponse(requestUrl);
	}

	protected E getResponse(Map<String, String> extraParams) throws IOException, SAXException {
		String requestUrl = EVE_API_URL + pageURL;
		boolean first = true;
		for (Entry<String, String> entry : extraParams.entrySet()) {
			if(first)
				requestUrl += "?";
			else
				requestUrl += "&";
			requestUrl +=  entry.getKey() + "=" + entry.getValue();
			first=false;
		}
		return getResponse(requestUrl);
	}

	protected E getResponse(String paramName, String paramValue) throws IOException, SAXException {
		return getResponse(EVE_API_URL + pageURL+ "?" + paramName + "=" + paramValue);
	}

	protected E getResponse() throws IOException, SAXException {
		return getResponse(EVE_API_URL + pageURL);
	}

	private E getResponse(String requestUrl) throws IOException, SAXException {
		return getResponse(requestUrl, getDigester());
	}

	@SuppressWarnings("unchecked")
	private E getResponse(String requestUrl, Digester digester) throws IOException, SAXException {
		if (logger.isDebugEnabled())
			logger.debug(requestUrl);
		if (isCachingEnabled() && isCached(requestUrl))
			return cache.get(requestUrl);
		E response = (E) digester.parse(requestUrl);
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
