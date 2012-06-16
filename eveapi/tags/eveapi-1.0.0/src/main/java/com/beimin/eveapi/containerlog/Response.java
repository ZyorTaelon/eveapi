package com.beimin.eveapi.containerlog;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final List<ApiContainerLog> containerLogs = new ArrayList<ApiContainerLog>();

	public void addContainerLog(ApiContainerLog containerLog) {
		containerLogs.add(containerLog);
	}

	public List<ApiContainerLog> getContainerLogs() {
		return containerLogs;
	}
}