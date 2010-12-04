package com.beimin.eveapi;

import java.util.Date;

import com.beimin.eveapi.utils.DateUtils;

public class ApiError {
	private int code;
	private String error;
	private Date retryAfterDate = null;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
		try {
			int retryIndex = error.indexOf("retry after ");
			if (retryIndex > 0) {
				int beginIndex = retryIndex + 12;
				String substring = error.substring(beginIndex, beginIndex + 19);
				retryAfterDate = DateUtils.getGMTConverter().convert(Date.class, substring);
			}
		} catch (Exception e) {
			// ignore.
		}
	}

	public boolean hasRetryAfterDate() {
		return retryAfterDate != null;
	}

	public Date getRetryAfterDate() {
		return retryAfterDate;
	}

	@Override
	public String toString() {
		return code + ": " + error;
	}
}