package com.betterbe.eveapi;

import java.util.Date;

public class ApiResponse {
	private int version;
	private Date currentTime;
	private Date cachedUntil;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public Date getCachedUntil() {
		return cachedUntil;
	}

	public void setCachedUntil(Date cachedUntil) {
		this.cachedUntil = cachedUntil;
	}
}
