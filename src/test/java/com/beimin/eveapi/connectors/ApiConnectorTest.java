package com.beimin.eveapi.connectors;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.account.ApiKeyInfoHandler;
import com.beimin.eveapi.parser.ApiAuthorization;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.ApiRequest;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;

@RunWith(PowerMockRunner.class)
public class ApiConnectorTest {
    private ApiConnector classToTest;
    @Mock
    private SAXParserFactory saxParserFactory;
    @Mock
    private SAXParser saxParser;
    @Mock
    private XMLReader xmlReader;

    @Before
    public void setUp() throws ParserConfigurationException, SAXException {
        classToTest = new ApiConnector();

        PowerMockito.mockStatic(SAXParserFactory.class);
        PowerMockito.when(SAXParserFactory.newInstance()).thenReturn(saxParserFactory);
        when(saxParserFactory.newSAXParser()).thenReturn(saxParser);
        when(saxParser.getXMLReader()).thenReturn(xmlReader);
    }

    @PrepareForTest(SAXParserFactory.class)
    @Test
    public void withSecureXmlProcessing() throws ApiException, ParserConfigurationException, SAXException {
        final ApiRequest request = getRequest();
        ApiConnector.setSecureXmlProcessing(true);

        classToTest.execute(request, new ApiKeyInfoHandler(), ApiKeyInfoResponse.class);

        verify(xmlReader).setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
    }

    @PrepareForTest(SAXParserFactory.class)
    @Test
    public void withoutSecureXmlProcessing() throws ApiException, ParserConfigurationException, SAXException {
        final ApiRequest request = getRequest();
        ApiConnector.setSecureXmlProcessing(false);

        classToTest.execute(request, new ApiKeyInfoHandler(), ApiKeyInfoResponse.class);

        verify(xmlReader, never()).setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
    }

    private ApiRequest getRequest() {
        final ApiAuthorization authorization = new ApiAuthorization(12345, "");
        final ApiRequest request = new ApiRequest(ApiPath.ACCOUNT, ApiPage.API_KEY_INFO, 2, authorization);
        return request;
    }
}
