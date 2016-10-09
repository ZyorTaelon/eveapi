package com.beimin.eveapi.utils;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.After;
import org.junit.Before;

import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;

public abstract class NoAuthParserTest implements ExchangeProcessor.ExtraAsserts {
    private final CamelContext context = new DefaultCamelContext();
    private final ApiPath path;
    private final ApiPage page;

    public NoAuthParserTest(final ApiPath apiUrl, final ApiPage returnXmlFile) {
        this(apiUrl, returnXmlFile, "");
    }

    public NoAuthParserTest(final ApiPath path, final ApiPage page, final String fileSuffix) {
        this.path = path;
        this.page = page;
    }

    @Before
    public void setup() throws Exception {
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {

                from("jetty:" + MockApi.URL + path.getPath() + "/" + page.getPage() + ".xml.aspx").process(new ExchangeProcessor(NoAuthParserTest.this, getResourcePath())).end();
            }
        });
        context.start();
        AbstractApiParser.setConnector(new ApiConnector(MockApi.URL));
    }

    protected String getResourcePath() {
        return path.getPath() + "/" + page.getPage() + ".xml";
    }

    protected ApiPage getPage() {
        return page;
    }

    protected ApiPath getPath() {
        return path;
    }

    @Override
    public void extraAsserts(final Map<String, String> req) {
        // overridable
    }

    @After
    public void cleanup() throws Exception {
        context.stop();
    }
}

