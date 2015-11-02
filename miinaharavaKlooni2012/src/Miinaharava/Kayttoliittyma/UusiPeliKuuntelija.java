package Miinaharava.Kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 * Tässä luokassa määritellään Uusipeli-napin painamiseen liittyvä toiminnallisuus
 *   
 */
public class UusiPeliKuuntelija implements ActionListener {

    private GraafinenKayttoliittyma liittyma;

    public UusiPeliKuuntelija(GraafinenKayttoliittyma liittyma) {
        this.liittyma = liittyma;
    }

    /**
     * Metodissa suljetaan nykyinen peli-ikkuna, ja luodaan uusi AloitusKysely-olio,
     * jota kautta pelaaja pääsee aloittamaan uuden pelin
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        liittyma.getFrame().setVisible(false);
        liittyma.getFrame().dispose();

        AloitusKysely kysely = new AloitusKysely();
        SwingUtilities.invokeLater(kysely);


    }
}
