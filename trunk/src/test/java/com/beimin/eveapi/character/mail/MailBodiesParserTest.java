package com.beimin.eveapi.character.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.character.mail.bodies.ApiMailBody;
import com.beimin.eveapi.character.mail.bodies.MailBodiesParser;
import com.beimin.eveapi.character.mail.bodies.MailBodiesResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MailBodiesParserTest extends FullAuthParserTest {
	public MailBodiesParserTest() {
		super(ApiPath.CHARACTER, ApiPage.MAIL_BODIES);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		MailBodiesParser parser = MailBodiesParser.getInstance();
		MailBodiesResponse response = parser.getResponse(auth, 299279683L, 299280303L);
		assertNotNull(response);
		Set<ApiMailBody> mailBodies = response.getMailBodies();
		assertNotNull(mailBodies);
		assertEquals(2, mailBodies.size());
		boolean found = false;
		for (ApiMailBody mail : mailBodies) {
			if (mail.getMessageID() == 299279683L) {
				found = true;
				String expected = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin purus orci, <br>faucibus nec lacinia sit amet, dapibus vitae sem. Phasellus massa sem, lacinia porta <br>semper facilisis, accumsan eu orci. In hac habitasse platea dictumst. <br>Curabitur iaculis enim ut purus tempus in porttitor tellus tempus. Cum <a href=\"sociis natoque penatibus\"> et magnis </a>dis parturient montes, <br>nascetur ridiculus mus. Praesent pulvinar, magna ac pulvinar condimentum, lectus neque pretium <br>arcu, sit amet egestas lorem sapien in eros. Vestibulum vulputate iaculis nulla, nec porta nisl ullamcorper sit amet. <br>Aenean placerat ultricies quam, eget lobortis diam rutrum sit amet. Etiam eget lacus id nisl vehicula laoreet ut ac nibh. Quisque vel neque vel neque pretium consequat vel ac lectus. <br>Nam ultricies, nibh sit amet pretium suscipit, nisi dui varius dui, at tristique sapien turpis sit amet diam.";
				assertEquals(expected, mail.getBody());
				break;
			}
		}
		assertTrue("Test mail wasn't found.", found);
	}

	protected void extraAsserts(HttpServletRequest req) {
		assertEquals("299279683,299280303", req.getParameter("ids"));
	}
}