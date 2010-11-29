package com.beimin.eveapi.corporation.member.security.log;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.corporation.member.security.ApiSecurityRole;

public class MemberSecurityLogParser extends AbstractApiParser<MemberSecurityLogResponse> {
	protected static final String MEMBER_SECURITY_LOG_URL = "/corp/MemberSecurityLog";

	public MemberSecurityLogParser() {
		super(MemberSecurityLogResponse.class, 2, MEMBER_SECURITY_LOG_URL);
	}

	public MemberSecurityLogResponse getMembers(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiRoleHistory.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addFactoryCreate("eveapi/result/rowset/row/rowset", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				String name = attributes.getValue("name");
				if (name != null) {
					SecurityRoleBag roleBag = new SecurityRoleBag();
					roleBag.setName(name);
					return roleBag;
				}
				return null;
			}
		});
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiSecurityRole.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addSecurityRole");
		digester.addSetNext("eveapi/result/rowset/row/rowset", "addSecurityRoleBag");
		digester.addSetNext("eveapi/result/rowset/row", "addRoleHistory");
		return digester;
	}

	public static MemberSecurityLogParser getInstance() {
		return new MemberSecurityLogParser();
	}
}