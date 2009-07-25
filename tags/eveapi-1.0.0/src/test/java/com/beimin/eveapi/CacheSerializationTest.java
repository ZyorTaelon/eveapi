package com.beimin.eveapi;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.map.jumps.Parser;

public class CacheSerializationTest {

	@Test
	public void serialization() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		parser.setCachingEnabled(true);
		parser.setSerializeCaching(true);
		parser.getJumps();
	}

}
