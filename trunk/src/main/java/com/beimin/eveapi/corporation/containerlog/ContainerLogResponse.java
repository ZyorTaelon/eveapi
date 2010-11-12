package com.beimin.eveapi.corporation.containerlog;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class ContainerLogResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<ApiContainerLog> containerLogs = new ArrayList<ApiContainerLog>();

	public void addContainerLog(ApiContainerLog containerLog) {
		containerLogs.add(containerLog);
	}

	public List<ApiContainerLog> getContainerLogs() {
		return containerLogs;
	}
}