/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MiinaharavanTestit;

import Miinaharava.Sovelluslogiikka.Luukku;
import Miinaharava.Sovelluslogiikka.OmaPeli;
import Miinaharava.Sovelluslogiikka.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {

    private Peli peli;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        peli = new OmaPeli(10, 10, 10);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alustaPeliTest() {
        assertTrue(peli != null);
    }

    @Test
    public void avaaViereisetRuudutTest() {
        Peli peli2 = new OmaPeli(10, 10, 0);
        peli2.avaaViereisetRuudut(0);
        assertTrue(peli2.kaikkiAvattu());
    }

    @Test
    public void avaaLuukkuTest() {
        Peli peli2 = new OmaPeli(3, 3, 3);
        Luukku avattu = peli2.avaaLuukku(0);
        assertTrue(peli2.getPiilotettuAlusta().get(0) == avattu);
    }

    @Test
    public void paljastaMiinatTest() {
        peli.paljastaMiinat();
        int laskuri = 0;
        for (Luukku i : peli.getPiilotettuAlusta()) {
            if (i == Luukku.MIINA) {
                laskuri++;
            }
        }
        assertTrue(laskuri == 10);
    }

    @Test
    public void luukkuAvattuTest() {
        peli.avaaLuukku(99);
        if (peli.getPeliAlusta().getLuukut().get(99) != Luukku.MIINA) {
            assertTrue(peli.luukkuAvattu(99));
        }
    }

    @Test
    public void kaikkiAvattuTest() {
        Peli peli2 = new OmaPeli(2, 2, 3);
        peli2.avaaLuukku(0);
        if (peli2.getPeliAlusta().getLuukut().get(0) != Luukku.MIINA) {
            assertTrue(peli2.kaikkiAvattu());
        }
    }

    @Test
    public void paljastaLiputTest() {
        peli.paljastaLiput();
        int laskuri = 0;
        for (Luukku luukku : peli.getPiilotettuAlusta()) {
            if (luukku == Luukku.MERKITTY) {
                laskuri++;
            }
        }
        assertTrue(laskuri == 10);
    }

    @Test
    public void merkitseLipullaTaiPoistaMerkintaTest1() {
        peli.merkitseLipullaTaiPoistaMerkinta(99);
        peli.merkitseLipullaTaiPoistaMerkinta(99);
        int laskuri = 0;
        for (Luukku luukku : peli.getPiilotettuAlusta()) {
            if (luukku == Luukku.PIILOTETTU) {
                laskuri++;
            }
        }
        assertTrue(laskuri == 100);
    }

    @Test
    public void merkitseLipullaTaiPoistaMerkintaTest2() {
        peli.merkitseLipullaTaiPoistaMerkinta(6);

        int laskuri = 0;
        for (Luukku luukku : peli.getPiilotettuAlusta()) {
            if (luukku == Luukku.PIILOTETTU) {
                laskuri++;
            }
        }
        assertTrue(laskuri == 99);
    }
}
