package com.beimin.eveapi.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ApiRequest implements Comparable<ApiRequest> {
	private final ApiPath path;
	private final ApiPage page;
	private final int version;
	private final ApiAuth auth;
	private final Map<String, String> params;

	public ApiRequest(ApiPath path, ApiPage page, int version, ApiAuth auth, Map<String, String> params) {
		this.path = path;
		this.page = page;
		this.version = version;
		this.auth = auth;
		this.params = params;
	}

	public ApiRequest(ApiPath path, ApiPage page, int version, Map<String, String> params) {
		this(path, page, version, null, params);
	}

	public ApiRequest(ApiPath path, ApiPage page, int version, ApiAuth auth) {
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

	public ApiAuth getAuth() {
		return auth;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public int compareTo(ApiRequest o) {
		return equals(o) ? 0 : 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auth == null) ? 0 : auth.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + version;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiRequest other = (ApiRequest) obj;
		if (auth == null) {
			if (other.auth != null)
				return false;
		} else if (!auth.equals(other.auth))
			return false;
		if (page != other.page)
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		if (path != other.path)
			return false;
		if (version != other.version)
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