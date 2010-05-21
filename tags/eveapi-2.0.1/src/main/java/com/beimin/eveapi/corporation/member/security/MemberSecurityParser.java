package com.beimin.eveapi.corporation.member.security;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class MemberSecurityParser extends AbstractApiParser<MemberSecurityResponse> {
	protected static final String MEMBER_SECURITY_URL = "/corp/MemberSecurity.xml.aspx";

	public MemberSecurityParser() {
		super(MemberSecurityResponse.class, 2, MEMBER_SECURITY_URL);
	}

	public MemberSecurityResponse getMembers(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/member", ApiSecurityMember.class);
		digester.addSetProperties("eveapi/result/member");
		digester.addFactoryCreate("eveapi/result/member/rowset", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				String name = attributes.getValue("name");
				if (name != null) {
					SecurityRoleOrTitleBag roleBag = new SecurityRoleOrTitleBag();
					roleBag.setName(name);
					return roleBag;
				}
				return null;
			}
		});
		digester.addObjectCreate("eveapi/result/member/rowset/row", SecurityRoleOrTitle.class);
		digester.addSetProperties("eveapi/result/member/rowset/row");
		digester.addSetNext("eveapi/result/member/rowset/row", "addSecurityRole");
		digester.addSetNext("eveapi/result/member/rowset", "addSecurityRoleBag");
		digester.addSetNext("eveapi/result/member", "addMember");
		return digester;
	}

	public static MemberSecurityParser getInstance() {
		return new MemberSecurityParser();
	}
}