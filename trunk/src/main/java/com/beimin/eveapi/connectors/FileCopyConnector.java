package com.beimin.eveapi.connectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import org.apache.commons.digester.Digester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiRequest;
import com.beimin.eveapi.core.ApiResponse;
import com.beimin.eveapi.utils.InputStreamSplitter;

public class FileCopyConnector extends ApiConnector {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final ApiConnector baseConnector;
	private final File destinationDirectory;

	public FileCopyConnector(File destinationDirectory) {
		this(null, destinationDirectory);
	}

	public FileCopyConnector(ApiConnector baseConnector, File destinationDirectory) {
		this.baseConnector = baseConnector;
		this.destinationDirectory = destinationDirectory;
		if (!this.destinationDirectory.exists())
			this.destinationDirectory.mkdirs();
	}

	@Override
	public <E extends ApiResponse> E execute(ApiRequest request, Digester digester, Class<E> clazz) throws ApiException {
		ApiConnector connector = getConnector();
		URL url = connector.getURL(request);
		InputStream inputStream = connector.getInputStream(url);
		String outputFileName = request.getPage().getPage() + "-" + new Date().getTime() + ".xml";
		File outputFile = new File(destinationDirectory, outputFileName);
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(outputFile);
			inputStream = new InputStreamSplitter(inputStream, outputStream);
		} catch (FileNotFoundException e) {
			logger.error("Could not write response xml to file: ", e);
		}
		E response = getApiResponse(digester, inputStream, clazz);
		if (outputStream != null) {
			try {
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				logger.error("Could not flush/close response xml file: ", e);
			}
		}
		return response;
	}

	@Override
	protected ApiConnector getConnector() {
		if (baseConnector != null)
			return baseConnector;
		return super.getConnector();
	}
}