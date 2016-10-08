package com.beimin.eveapi.eve.typename;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.EveTypeName;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.TypeNameParser;
import com.beimin.eveapi.response.eve.TypeNameResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class TypeNameParserTest extends NoAuthParserTest {
    public TypeNameParserTest() {
        super(ApiPath.EVE, ApiPage.TYPE_NAME);
    }

    @Test
    public void getResponse() throws ApiException {
        final TypeNameParser parser = new TypeNameParser();
        final TypeNameResponse response = parser.getResponse(12345);
        final Collection<EveTypeName> chars = response.getAll();
        assertEquals(1, chars.size());
        final EveTypeName typeName = chars.iterator().next();
        assertEquals("200mm Railgun I Blueprint", typeName.getTypeName());
        assertEquals(12345, typeName.getTypeID());
    }

    @Override
    public void extraAsserts(final Map<String, String> req) {
        super.extraAsserts(req);
        assertEquals("12345", req.get("ids"));
    }
}
