package com.beimin.eveapi.response;

public class ServerStatusResponse extends ApiResponse {
    private boolean serverOpen;
    private int onlinePlayers;

    public boolean isServerOpen() {
        return serverOpen;
    }

    public void setServerOpen(final boolean serverOpen) {
        this.serverOpen = serverOpen;
    }

    public int getOnlinePlayers() {
        return onlinePlayers;
    }

    public void setOnlinePlayers(final int onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }
}
