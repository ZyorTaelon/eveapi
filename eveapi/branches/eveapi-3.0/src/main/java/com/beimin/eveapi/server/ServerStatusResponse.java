package com.beimin.eveapi.server;

import com.beimin.eveapi.core.ApiResponse;

public class ServerStatusResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private boolean serverOpen;
	private int onlinePlayers;

	public boolean isServerOpen() {
		return serverOpen;
	}

	public void setServerOpen(boolean serverOpen) {
		this.serverOpen = serverOpen;
	}

	public int getOnlinePlayers() {
		return onlinePlayers;
	}

	public void setOnlinePlayers(int onlinePlayers) {
		this.onlinePlayers = onlinePlayers;
	}
}
