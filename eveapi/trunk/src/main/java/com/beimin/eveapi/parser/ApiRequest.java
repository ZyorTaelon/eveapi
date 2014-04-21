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
		StringBuilder temp = new StringBuilder(path.getPath());
		temp.append(page).append(version);
		if (auth != null)
			temp.append(auth.getKeyID()).append(auth.getCharacterID()).append(auth.getVCode());
		for (Entry<String, String> entry : params.entrySet()) {
			temp.append(entry.getKey()).append(entry.getValue());
		}
		return temp.toString().hashCode();
	}

	public int compareTo(ApiRequest o) {
		return o.hashCode() - hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ApiRequest)
			return compareTo((ApiRequest) obj) == 0;
		return false;
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