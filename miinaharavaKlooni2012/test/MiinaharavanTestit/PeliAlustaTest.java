/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MiinaharavanTestit;

import Miinaharava.Sovelluslogiikka.Luukku;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import Miinaharava.Sovelluslogiikka.PeliAlusta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PeliAlustaTest {

    public PeliAlustaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void peliAlustanLuontiTest() {
        PeliAlusta alusta = new PeliAlusta(4, 4, 4);
        assertTrue(alusta != null);
    }

    @Test
    public void onViereisetTest() {
        PeliAlusta alusta = new PeliAlusta(10, 10, 10);

        assertTrue(!alusta.onViereiset(9, 10));
        assertTrue(alusta.onViereiset(15, 4));
        assertTrue(alusta.onViereiset(30, 40));
        assertTrue(!alusta.onViereiset(30, 39));
    }

    @Test
    public void kaikkiViereisetRuudutTaulukossaTest1() {
        PeliAlusta alusta = new PeliAlusta(4, 4, 4);
        List<Integer> ruudut = alusta.kaikkiViereisetRuudutTaulukossa(0);
        ArrayList<Integer> oma = new ArrayList<Integer>();
        oma.add(1);
        oma.add(5);
        oma.add(4);
        Collections.sort(oma);
        Collections.sort(ruudut);
        assertEquals(ruudut, oma);

    }

    @Test
    public void kaikkiViereisetRuudutTaulukossaTest2() {
        PeliAlusta alusta = new PeliAlusta(3, 3, 3);
        List<Integer> ruudut = alusta.kaikkiViereisetRuudutTaulukossa(5);
        ArrayList<Integer> oma = new ArrayList<Integer>();
        oma.add(1);
        oma.add(2);
        oma.add(4);
        oma.add(8);
        oma.add(7);
        Collections.sort(oma);
        Collections.sort(ruudut);
        assertEquals(ruudut, oma);

    }

    @Test
    public void asetaKaikkiNumerotTest() {
        PeliAlusta alusta = new PeliAlusta(10, 10, 1);
        int laskuri0 = 0;
        int laskuri1 = 0;
        int laskuri9 = 0;
        for (Luukku i : alusta.getLuukut()) {
            if (i == Luukku.VIERESSA0) {
                laskuri0++;
            } else if (i == Luukku.VIERESSA1) {
                laskuri1++;
            } else {
                laskuri9++;
            }
        }
        assertTrue(laskuri0 >= 91);
        assertTrue(laskuri1 <= 8);
        assertTrue(laskuri9 == 1);
    }
}
