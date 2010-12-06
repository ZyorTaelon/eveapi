package com.beimin.eveapi.character.sheet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Test;


import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.character.EveBloodline;
import com.beimin.eveapi.shared.character.EveRace;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class SheetParserTest extends FullAuthParserTest {
	public SheetParserTest() {
		super(ApiPath.CHARACTER, ApiPage.CHARACTER_SHEET);
	}

	@Test
	public void getResponse() throws ApiException {
		CharacterSheetParser parser = CharacterSheetParser.getInstance();
		CharacterSheetResponse response = parser.getResponse(auth);
		assertNotNull(response);
		assertEquals(150337897L, response.getCharacterID());
		assertEquals("corpslave", response.getName());
		assertEquals(EveRace.MINMATAR, response.getRace());
		assertEquals(EveBloodline.BRUTOR, response.getBloodLine());
		assertEquals("Female", response.getGender());
		assertEquals("corpexport Corp", response.getCorporationName());
		assertEquals(150337746L, response.getCorporationID());
		assertEquals(190210393.87, response.getBalance(), 0.00001);

		Set<ApiAttributeEnhancer> attributeEnhancers = response.getAttributeEnhancers();
		assertEquals(2, attributeEnhancers.size());
		for (ApiAttributeEnhancer enhancer : attributeEnhancers) {
			if (enhancer.getAttribute().equals("intelligence")) {
				assertEquals("Snake Delta", enhancer.getAugmentatorName());
				assertEquals(3, enhancer.getAugmentatorValue());
			} else if (enhancer.getAttribute().equals("memory")) {
				assertEquals("Halo Beta", enhancer.getAugmentatorName());
				assertEquals(2, enhancer.getAugmentatorValue());
			} else {
				fail("attributeEnhancer parsing failed");
			}
		}

		assertEquals(6, response.getIntelligence());
		assertEquals(4, response.getMemory());
		assertEquals(7, response.getCharisma());
		assertEquals(12, response.getPerception());
		assertEquals(10, response.getWillpower());

		Set<ApiSkill> skills = response.getSkills();
		assertEquals(5, skills.size());
		for (ApiSkill skill : skills) {
			if (skill.getTypeID() == 3431) {
				assertEquals(3, skill.getLevel());
				assertEquals(8000, skill.getSkillpoints());
			} else if (skill.getTypeID() == 3413) {
				assertEquals(3, skill.getLevel());
				assertEquals(8000, skill.getSkillpoints());
			} else if (skill.getTypeID() == 21059) {
				assertEquals(1, skill.getLevel());
				assertEquals(500, skill.getSkillpoints());
			} else if (skill.getTypeID() == 3416) {
				assertEquals(3, skill.getLevel());
				assertEquals(8000, skill.getSkillpoints());
			} else if (skill.getTypeID() == 3445) {
				assertEquals(true, skill.isUnpublished());
				assertEquals(277578, skill.getSkillpoints());
			} else {
				fail("skill parsing failed");
			}
		}
	}
}