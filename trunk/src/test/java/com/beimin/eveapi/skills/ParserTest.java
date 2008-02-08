package com.beimin.eveapi.skills;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.betterbe.eveapi.skills.Parser;
import com.betterbe.eveapi.skills.Response;

public class ParserTest {
	@Test
	public void testSkillParser() throws IOException, SAXException {
		Response response = Parser.getInstance().getSkills();
		assertEquals("version 2 expected", 2, response.getVersion());

	}
}
