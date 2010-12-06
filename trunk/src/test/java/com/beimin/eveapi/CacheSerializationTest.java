package com.beimin.eveapi;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.map.jumps.MapJumpsParser;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class CacheSerializationTest extends NoAuthParserTest {
	public CacheSerializationTest() {
		super(ApiPath.MAP, ApiPage.JUMPS);
	}

	@Ignore
	@Test
	@SuppressWarnings("unused")
	public void testSerialization() throws IOException, SAXException {
		MapJumpsParser parser = MapJumpsParser.getInstance();
		parser.setCachingEnabled(true);
		parser.setSerializeCaching(true);
		// parser.getResponse();
	}

}
