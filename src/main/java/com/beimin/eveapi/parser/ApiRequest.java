package com.beimin.eveapi.parser;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ApiRequest implements Comparable<ApiRequest>, Serializable {
	private static final long serialVersionUID = 1L;
	private final ApiPath path;
	private final ApiPage page;
	private final int version;
	private final ApiAuth<?> auth;
	private final Map<String, String> params;

	public ApiRequest(ApiPath path, ApiPage page, int version, ApiAuth<?> auth, Map<String, String> params) {
		this.path = path;
		this.page = page;
		this.version = version;
		this.auth = auth;
		this.params = params;
	}

	public ApiRequest(ApiPath path, ApiPage page, int version, Map<String, String> params) {
		this(path, page, version, null, params);
	}

	public ApiRequest(ApiPath path, ApiPage page, int version, ApiAuth<?> auth) {
		this(path, page, version, auth, new HashMap<String, String>());
	}

	public ApiRequest(ApiPath path, ApiPage page, int version) {
		this(path, page, version, null, new HashMap<String, String>());
	}

	public ApiPath getPath() {
		return path;
	}

	public ApiPage getPage() {
		return page;
	}

	public int getVersion() {
		return version;
	}

	public ApiAuth<?> getAuth() {
		return auth;
	}

	public Map<String, String> getParams() {
		return params;
	}

	@Override
	public int hashCode() {
		int result = path != null ? path.hashCode() : 0;
		result = 31 * result + (page != null ? page.hashCode() : 0);
		result = 31 * result + version;
		result = 31 * result + (auth != null ? auth.hashCode() : 0);
		result = 31 * result + (params != null ? params.hashCode() : 0);
		return result;
	}

	public int compareTo(ApiRequest o) {
		return equals(o) ? 0 : 1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ApiRequest))
			return false;
		ApiRequest that = (ApiRequest) o;
		if (version != that.version)
			return false;
		if (auth != null ? !auth.equals(that.auth) : that.auth != null)
			return false;
		if (page != that.page)
			return false;
		if (params != null ? !params.equals(that.params) : that.params != null)
			return false;
		if (path != that.path)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Path: ").append(path.getPath()).append("\n");
		result.append("Page: ").append(page.getPage()).append("\n");
		result.append("Version: ").append(version).append("\n");
		result.append("Auth: ").append(auth.toString()).append("\n");
		for (Entry<String, String> entry : params.entrySet()) {
			result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
		}
		return result.toString();
	}
}