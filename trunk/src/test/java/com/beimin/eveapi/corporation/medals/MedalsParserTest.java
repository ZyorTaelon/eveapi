package com.beimin.eveapi.corporation.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.medals.Medal;
import com.beimin.eveapi.shared.medals.MedalsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MedalsParserTest extends FullAuthParserTest {
	public MedalsParserTest() {
		super(ApiPath.CORPORATION, ApiPage.MEDALS);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		MedalsParser parser = MedalsParser.getInstance();
		MedalsResponse response = parser.getResponse(auth);
		assertNotNull(response);
		List<Medal> medals = response.getMedals();
		assertEquals("Incorrect amount of members found.", 18, medals.size());
		Medal medal = medals.iterator().next();
		assertEquals("Wrong member characterID", 1745, medal.getMedalID());
		assertEquals("Wrong member name", "Capital Red Eyed Award", medal.getTitle());
		assertEquals(
				"Wrong member name",
				"This award is given to captial pilots that not only fought on the front lines but stayed up way to late and past their 9pm bedtimes to kill the scum that think they are better than us.",
				medal.getDescription());
		if (medal instanceof CorpMedal) {
			CorpMedal corpMedal = (CorpMedal) medal;
			assertEquals("Wrong member name", 817217271L, corpMedal.getCreatorID());
			assertDate(2008, 11, 12, 7, 37, 0, corpMedal.getCreated());
		} else {
			fail("wrong medal type.");
		}
	}
}