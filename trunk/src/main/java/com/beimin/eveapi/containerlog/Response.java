package com.beimin.eveapi.containerlog;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final List<ContainerLog> containerLogs = new ArrayList<ContainerLog>();

	public void addContainerLog(ContainerLog containerLog) {
		containerLogs.add(containerLog);
	}

	public List<ContainerLog> getContainerLogs() {
		return containerLogs;
	}
}