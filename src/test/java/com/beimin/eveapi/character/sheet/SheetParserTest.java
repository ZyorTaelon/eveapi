package com.beimin.eveapi.character.sheet;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.character.Implant;
import com.beimin.eveapi.model.character.JumpClone;
import com.beimin.eveapi.model.character.JumpCloneImplant;
import com.beimin.eveapi.model.character.Role;
import com.beimin.eveapi.model.character.Skill;
import com.beimin.eveapi.model.shared.Ancestry;
import com.beimin.eveapi.model.shared.Bloodline;
import com.beimin.eveapi.model.shared.Race;
import com.beimin.eveapi.model.shared.Title;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.CharacterSheetParser;
import com.beimin.eveapi.response.character.CharacterSheetResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class SheetParserTest extends FullAuthParserTest {
    public SheetParserTest() {
        super(ApiPath.CHARACTER, ApiPage.CHARACTER_SHEET);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharacterSheetParser parser = new CharacterSheetParser();
        final CharacterSheetResponse response = parser.getResponse(auth);
        assertNotNull(response);
        assertEquals(987623974L, response.getCharacterID());
        assertEquals("Golden Gnu", response.getName());
        assertEquals(0, response.getHomeStationID());
        assertDate(2008, 2, 16, 20, 36, 0, response.getDateOfBirth()); // 2008-02-16 20:36:00
        assertEquals(Race.GALLENTE, response.getRace());
        assertEquals(12, response.getBloodLineID());
        assertEquals(Bloodline.JIN_MEI, response.getBloodLine());
        assertEquals(36, response.getAncestryID());
        assertEquals(Ancestry.JING_KO_CASTE, response.getAncestry());
        assertEquals("Male", response.getGender());
        assertEquals("EVE University", response.getCorporationName());
        assertEquals(917701062, response.getCorporationID());
        assertEquals("Ivy League", response.getAllianceName());
        assertEquals(937872513L, (long) response.getAllianceID());
        assertEquals("", response.getFactionName());
        assertEquals(0L, (long) response.getFactionID());
        assertEquals(164, response.getCloneTypeID());
        assertEquals("Clone Grade Alpha", response.getCloneName());
        assertEquals(0L, response.getCloneSkillPoints());
        assertEquals(350000L, response.getFreeSkillPoints());
        assertEquals(1, response.getFreeRespecs());
        assertDate(2011, 10, 28, 11, 15, 0, response.getCloneJumpDate()); // 2011-10-28 11:15:00
        assertDate(2016, 7, 7, 16, 22, 1, response.getLastRespecDate()); // 2016-07-07 16:22:01
        assertDate(2016, 7, 7, 16, 22, 1, response.getLastTimedRespec()); // 2016-07-07 16:22:01
        assertDate(1, 1, 1, 0, 0, 0, response.getRemoteStationDate());
        assertDate(1, 1, 1, 0, 0, 0, response.getJumpActivation());
        assertDate(1, 1, 1, 0, 0, 0, response.getJumpFatigue());
        assertDate(1, 1, 1, 0, 0, 0, response.getJumpLastUpdate());
        assertEquals(1800143781.42, response.getBalance(), 0.00001);
        assertEquals(17, response.getIntelligence());
        assertEquals(17, response.getMemory());
        assertEquals(27, response.getCharisma());
        assertEquals(17, response.getPerception());
        assertEquals(21, response.getWillpower());

        List<JumpClone> jumpClones = response.getJumpClones();
        assertEquals(2, jumpClones.size());
        int jumpClonesFound = 0;
        for (final JumpClone jumpClone : jumpClones) {
            if (jumpClone.getJumpCloneID() == 12117789L) {
                jumpClonesFound++;
                assertEquals(164, jumpClone.getTypeID());
                assertEquals(60005311L, jumpClone.getLocationID());
                assertEquals("", jumpClone.getCloneName());
            } else if (jumpClone.getJumpCloneID() == 9858322L) {
                jumpClonesFound++;
                assertEquals(164, jumpClone.getTypeID());
                assertEquals(60011983L, jumpClone.getLocationID());
                assertEquals("", jumpClone.getCloneName());
            }
        }
        assertEquals(2, jumpClonesFound);

        List<JumpCloneImplant> jumpCloneImplants = response.getJumpCloneImplants();
        assertEquals(8, jumpCloneImplants.size());
        int jumpCloneImplantsFound = 0;
        for (final JumpCloneImplant jumpCloneImplant : jumpCloneImplants) {
            if (jumpCloneImplant.getJumpCloneID() == 9858322) {
                if (jumpCloneImplant.getTypeID() == 10208) {
                    jumpCloneImplantsFound++;
                    assertEquals("Memory Augmentation - Standard", jumpCloneImplant.getTypeName());
                } else if (jumpCloneImplant.getTypeID() == 10212) {
                    jumpCloneImplantsFound++;
                    assertEquals("Neural Boost - Standard", jumpCloneImplant.getTypeName());
                } else if (jumpCloneImplant.getTypeID() == 10216) {
                    jumpCloneImplantsFound++;
                    assertEquals("Ocular Filter - Standard", jumpCloneImplant.getTypeName());
                }
            }
        }
        assertEquals(3, jumpCloneImplantsFound);

        List<Implant> implants = response.getImplants();
        assertEquals(5, implants.size());
        int implantsFound = 0;
        for (final Implant implant : implants) {
            if (implant.getTypeID() == 10209) {
                implantsFound++;
                assertEquals("Memory Augmentation - Improved", implant.getTypeName());
            } else if (implant.getTypeID() == 10213) {
                implantsFound++;
                assertEquals("Neural Boost - Improved", implant.getTypeName());
            } else if (implant.getTypeID() == 10226) {
                implantsFound++;
                assertEquals("Social Adaptation Chip - Improved", implant.getTypeName());
            }
        }
        assertEquals(3, implantsFound);

        final List<Skill> skills = response.getSkills();
        assertEquals(284, skills.size());
        int skillsFound = 0;
        for (final Skill skill : skills) {
            if (skill.getTypeID() == 3431) {
                skillsFound++;
                assertEquals(5, skill.getLevel());
                assertEquals(256000, skill.getSkillpoints());
                assertTrue(skill.isPublished());
            } else if (skill.getTypeID() == 3413) {
                skillsFound++;
                assertEquals(5, skill.getLevel());
                assertEquals(256000, skill.getSkillpoints());
                assertTrue(skill.isPublished());
            } else if (skill.getTypeID() == 21059) {
                skillsFound++;
                assertEquals(5, skill.getLevel());
                assertEquals(512000, skill.getSkillpoints());
                assertTrue(skill.isPublished());
            } else if (skill.getTypeID() == 3416) {
                skillsFound++;
                assertEquals(5, skill.getLevel());
                assertEquals(256000, skill.getSkillpoints());
                assertTrue(skill.isPublished());
            }
        }

        assertEquals(4, skillsFound);
        Role role;
        assertEquals(5, response.getCorporationRoles().size());
        role = response.getCorporationRoles().iterator().next();
        assertEquals(1024L, role.getRoleID());
        assertEquals("roleFactoryManager", role.getRoleName());

        assertEquals(3, response.getCorporationRolesAtHQ().size());
        role = response.getCorporationRolesAtHQ().iterator().next();
        assertEquals(8192L, role.getRoleID());
        assertEquals("roleHangarCanTake1", role.getRoleName());

        assertEquals(0, response.getCorporationRolesAtBase().size());

        assertEquals(3, response.getCorporationRolesAtOther().size());
        role = response.getCorporationRolesAtOther().iterator().next();
        assertEquals(8192L, role.getRoleID());
        assertEquals("roleHangarCanTake1", role.getRoleName());

        assertEquals(1, response.getCorporationTitles().size());
        Title title = response.getCorporationTitles().iterator().next();
        assertEquals(8, title.getTitleID());
        assertEquals("Freshman", title.getTitleName());
    }
}
