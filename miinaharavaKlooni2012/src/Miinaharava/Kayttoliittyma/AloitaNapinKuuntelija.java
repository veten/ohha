package Miinaharava.Kayttoliittyma;

import Miinaharava.Sovelluslogiikka.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Tässä luokassa määritellään AloitaNapin painamisesta aiheutunut toiminnallisuus
 *   
 */
public class AloitaNapinKuuntelija implements ActionListener {

    private Peli peli;
    private JTextField leveys;
    private JTextField korkeus;
    private JTextField miinat;
    private AloitusKysely kysely;

    public AloitaNapinKuuntelija(JTextField leveys, JTextField korkeus, JTextField miinat, Peli peli, AloitusKysely kysely) {
        this.peli = peli;
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinat = miinat;
        this.kysely = kysely;
    }

    /**
     * Metodi määrittää toiminnan joka tapahtuu kun pelaaja painaa AloitaNappia. Jos pelaaja 
     * on antanut kelvolliset arvot, sulkee Aloituskysely-ruutu itsensä ja avaa varsinaiset 
     * pelaamisikkunan. Jos arvot eivät ole kelvolliset, palauttaa metodi pelaaajan infoikkunan 
     * kautta takaisin korjaamaan syötteitä
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            int levveys = Integer.parseInt(leveys.getText());
            int korkkeus = Integer.parseInt(korkeus.getText());
            int miinnat = Integer.parseInt(miinat.getText());


            if (levveys >= 0 && levveys <= 28 && korkkeus >= 0 && korkkeus <= 50 && miinnat >= 0 && miinnat < levveys * korkkeus) {
                peli = new OmaPeli(levveys, korkkeus, miinnat);
                GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma(peli);
                kayttoliittyma.run();
                kysely.getFrame().setVisible(false);
                kysely.getFrame().dispose();

            } else {
                JOptionPane.showMessageDialog(kysely.getFrame(),
                        "Arvo ei kelpaa.. Yritä uudelleen. Huomaa että, jotta peli olisi mielekäs, täytyy miinoja olla korkeintaan ruutujen määrä miinus yksi eli korkeintaan ((leveys  x  korkeus) -1)",
                        "Virheellinen arvo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ea) {
            JOptionPane.showMessageDialog(kysely.getFrame(),
                    "Aseta jokin numero kaikkiin kohtiin, muutoin peliä ei voida luoda",
                    "Virheellinen arvo", JOptionPane.INFORMATION_MESSAGE);

        }



    }
}
