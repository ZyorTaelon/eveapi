package com.beimin.eveapi.eve.typename;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class TypeNameParserTest extends NoAuthParserTest {
	public TypeNameParserTest() {
		super(ApiPath.EVE, ApiPage.TYPE_NAME);
	}

	@Test
	public void getResponse() throws ApiException {
		TypeNameParser parser = TypeNameParser.getInstance();
		TypeNameResponse response = parser.getResponse(12345);
		Collection<EveTypeName> chars = response.getAll();
		assertEquals(1, chars.size());
		EveTypeName typeName = chars.iterator().next();
		assertEquals("200mm Railgun I Blueprint", typeName.getTypeName());
		assertEquals(12345, typeName.getTypeID());
	}

	@Override
	public void extraAsserts(Map<String, String> req) {
		super.extraAsserts(req);
		assertEquals("12345", req.get("ids"));
	}
}