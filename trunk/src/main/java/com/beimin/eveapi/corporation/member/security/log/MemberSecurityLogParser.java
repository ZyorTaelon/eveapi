package com.beimin.eveapi.corporation.member.security.log;


import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.corporation.member.security.ApiSecurityRole;

public class MemberSecurityLogParser extends AbstractApiParser<MemberSecurityLogResponse> {
	public MemberSecurityLogParser() {
		super(MemberSecurityLogResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEMBER_SECURITY_LOG);
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

	@Override
	public MemberSecurityLogResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}
}