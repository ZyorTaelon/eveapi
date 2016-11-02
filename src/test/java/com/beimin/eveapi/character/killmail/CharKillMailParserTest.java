package com.beimin.eveapi.character.killmail;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Kill;
import com.beimin.eveapi.model.shared.KillAttacker;
import com.beimin.eveapi.model.shared.KillItem;
import com.beimin.eveapi.model.shared.KillVictim;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.CharKillMailParser;
import com.beimin.eveapi.response.shared.KillMailResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CharKillMailParserTest extends FullAuthParserTest {
    public CharKillMailParserTest() {
        super(ApiPath.CHARACTER, ApiPage.KILL_MAILS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharKillMailParser parser = new CharKillMailParser();
        final KillMailResponse response = parser.getResponse(auth);
        assertThat(response, notNullValue());
        final Collection<Kill> entries = response.getAll();
        assertThat(entries.size(), equalTo(18));
        boolean found = false;
        for (final Kill kill : entries) {
            if (kill.getKillID() == 4879947) {
                found = true;
                assertDate(2008, 12, 18, 23, 57, 0, kill.getKillTime());
                final KillVictim victim = kill.getVictim();
                assertThat(victim, notNullValue());

                assertThat(victim.getCharacterID(), equalTo(411109620L));
                assertThat(victim.getCharacterName(), equalTo("Pi'rat Tealon"));
                assertThat(victim.getCorporationID(), equalTo(1449814438L));
                assertThat(victim.getCorporationName(), equalTo("The Bastards"));
                assertThat(victim.getAllianceID().longValue(), equalTo(1311549668L));
                assertThat(victim.getAllianceName(), equalTo("The Bastards."));
                assertThat(victim.getFactionID(), equalTo(0));
                assertThat(victim.getFactionName(), equalTo(""));
                assertThat(victim.getDamageTaken(), equalTo(1415L));
                assertThat(victim.getShipTypeID(), equalTo(587L));

                final List<KillAttacker> attackers = kill.getAttackers();
                assertThat(attackers, notNullValue());
                assertThat(attackers.size(), equalTo(1));
                final KillAttacker attacker = attackers.iterator().next();
                assertThat(attacker.getCharacterID(), equalTo(1134301496L));
                assertThat("Blackfiredaemon", equalTo(attacker.getCharacterName()));
                assertThat(attacker.getCorporationID(), equalTo(1885670269L));
                assertThat("Letiferi Praedones", equalTo(attacker.getCorporationName()));
                assertThat(1652934118L, equalTo(attacker.getAllianceID().longValue()));
                assertThat("Wong Thong Crew", equalTo(attacker.getAllianceName()));
                assertThat(0, equalTo(attacker.getFactionID()));
                assertThat("", equalTo(attacker.getFactionName()));
                assertThat(attacker.getSecurityStatus(), equalTo(-3.72675620703378));
                assertThat(1415, equalTo(attacker.getDamageDone()));
                assertThat(true, equalTo(attacker.isFinalBlow()));
                assertThat(2897, equalTo(attacker.getWeaponTypeID()));
                assertThat(11999, equalTo(attacker.getShipTypeID()));

                final List<KillItem> items = kill.getItems();
                assertThat(items, notNullValue());
                assertThat(items.size(), equalTo(12));
                final KillItem item = items.iterator().next();
                assertThat(item.getTypeID(), equalTo(530L));
                assertThat(item.getFlag(), equalTo(0));
                assertThat(item.getQtyDropped(), equalTo(0));
                assertThat(item.getQtyDestroyed(), equalTo(1));
            }
        }
        assertThat("test KillMail entry wasn't found.", found, equalTo(true));
    }
}
