package com.beimin.eveapi.skill;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	private static final String SKILLS_URL = "/eve/SkillTree.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", SkillGroup.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSkillGroup");
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", Skill.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addBeanPropertySetter("eveapi/result/rowset/row/rowset/row/description");
		digester.addBeanPropertySetter("eveapi/result/rowset/row/rowset/row/rank");
		digester.addFactoryCreate("eveapi/result/rowset/row/rowset/row/rowset/row", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				if (attributes.getValue("typeID") != null)
					return new Requirement();
				if (attributes.getValue("bonusType") != null)
					return new Bonus();
				return null;
			}
		});
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row/rowset/row", "addSkillDetail");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addSkill");
		return digester;
	}

	public Response getSkills() throws IOException, SAXException {
		String requestUrl = EVE_API_URL + SKILLS_URL;
		return getResponse(requestUrl, getDigester());
	}

	public static Parser getInstance() {
		return new Parser();
	}
}