package com.beimin.eveapi.character.sheet;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.pilot.AttributeEnhancer;
import com.beimin.eveapi.model.pilot.Skill;
import com.beimin.eveapi.model.shared.Ancestry;
import com.beimin.eveapi.model.shared.Bloodline;
import com.beimin.eveapi.model.shared.Race;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.CharacterSheetParser;
import com.beimin.eveapi.response.pilot.CharacterSheetResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class SheetParserTest extends FullAuthParserTest {
	public SheetParserTest() {
		super(ApiPath.CHARACTER, ApiPage.CHARACTER_SHEET);
	}

	@Test
	public void getResponse() throws ApiException {
		CharacterSheetParser parser = new CharacterSheetParser();
		CharacterSheetResponse response = parser.getResponse(auth);
		assertNotNull(response);
		assertEquals(150337897L, response.getCharacterID());
		assertEquals("corpslave", response.getName());
		assertEquals(Race.MINMATAR, response.getRace());
		assertEquals(Ancestry.SLAVE_CHILD, response.getAncestry());
		assertDate(2006, 1, 1, 0, 0, 0, response.getDateOfBirth());
		assertEquals(Bloodline.BRUTOR, response.getBloodLine());
		assertEquals("Female", response.getGender());
		assertEquals("corpexport Corp", response.getCorporationName());
		assertNull(response.getAllianceName());
		assertEquals(150337746L, response.getCorporationID());
		assertEquals("Clone Grade Pi", response.getCloneName());
		assertEquals(54600000L, response.getCloneSkillPoints());
		assertEquals(190210393.87, response.getBalance(), 0.00001);

		Set<AttributeEnhancer> attributeEnhancers = response.getAttributeEnhancers();
		assertEquals(2, attributeEnhancers.size());
		for (AttributeEnhancer enhancer : attributeEnhancers) {
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

		Set<Skill> skills = response.getSkills();
		assertEquals(5, skills.size());
		for (Skill skill : skills) {
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
		assertEquals(1, response.getCorporationRoles().size());
		assertEquals(1, response.getCorporationRolesAtHQ().size());
		assertEquals(1, response.getCorporationRolesAtBase().size());
		assertEquals(1, response.getCorporationRolesAtOther().size());
		assertEquals(1, response.getCorporationTitles().size());
		assertEquals("Member", response.getCorporationTitles().iterator().next().getTitleName());
	}
}