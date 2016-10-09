package com.beimin.eveapi.eve.reftypes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.RefType;
import com.beimin.eveapi.parser.eve.RefTypesParser;
import com.beimin.eveapi.response.eve.RefTypesResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class RefTypeEnumGenerator {

    public static void main(final String[] args) throws IOException, TemplateException, ApiException {
        final RefTypesParser parser = new RefTypesParser();
        final RefTypesResponse response = parser.getResponse();
        final Collection<RefType> refTypes = response.getAll();
        final Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        final Template tpl = cfg.getTemplate("src/test/resources/refType.ftl");
        final FileWriter output = new FileWriter("src/test/java/com/beimin/eveapi/shared/wallet/RefType.java");
        final HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("refTypes", refTypes);
        tpl.process(model, output);
        output.flush();
        output.close();
    }
}

