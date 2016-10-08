package com.beimin.eveapi.connectors;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.parser.ApiRequest;
import com.beimin.eveapi.response.ApiResponse;
import com.beimin.eveapi.utils.InputStreamSplitter;

public class FileCopyConnector extends ApiConnector {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileCopyConnector.class);
    private final ApiConnector baseConnector;
    private final File destinationDirectory;

    public FileCopyConnector(final File destinationDirectory) {
        this(null, destinationDirectory);
    }

    public FileCopyConnector(final ApiConnector baseConnector, final File destinationDirectory) {
        super();
        this.baseConnector = baseConnector;
        this.destinationDirectory = destinationDirectory;
        if (!this.destinationDirectory.exists()) {
            if (!this.destinationDirectory.mkdirs()) {
                LOGGER.warn("Could not create directory: " + destinationDirectory.toString());
            }
        }
    }

    @Override
    public <E extends ApiResponse> E execute(final ApiRequest request, final AbstractContentHandler<E> contentHandler, final Class<E> clazz) throws ApiException {
        final ApiConnector connector = getConnector();
        final URL url = connector.getURL(request);
        final Map<String, String> params = connector.getParams(request);
        InputStream inputStream = connector.getInputStream(url, params);
        final String outputFileName = request.getPage().getPage() + "-" + new Date().getTime() + ".xml";
        final File outputFile = new File(destinationDirectory, outputFileName);
        E response = null;
        try (FileOutputStream outputStream = new FileOutputStream(outputFile);) {
            inputStream = new InputStreamSplitter(inputStream, outputStream);
            response = getApiResponse(contentHandler, inputStream, clazz);
        } catch (final IOException e) {
            LOGGER.error("Could not write response xml to file: ", e);
        }
        return response;
    }

    @Override
    public ApiConnector getNewInstance() {
        return new FileCopyConnector(baseConnector, destinationDirectory);
    }

    private ApiConnector getConnector() {
        if (baseConnector != null) {
            return baseConnector.getNewInstance();
        }
        return super.getNewInstance();
    }
}
