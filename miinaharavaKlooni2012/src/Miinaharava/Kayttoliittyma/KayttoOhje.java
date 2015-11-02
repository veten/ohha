package Miinaharava.Kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Tässä luokassa määritellään käyttöohje-painikkeen toiminta
 *   
 */
public class KayttoOhje implements ActionListener {

    private GraafinenKayttoliittyma liittyma;

    public KayttoOhje(GraafinenKayttoliittyma liittyma) {
        this.liittyma = liittyma;
    }

    /**
     * Metodi luo infoikkunan, johon tulee näkyviin pelin käyttöohjeet. Ok-nappia painamalla
     * pelaaja pääsee takaisin peliin
     *   
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(liittyma.getFrame(),
                "Pelikenttään on kätketty miinoja. Tehtävänäsi on avata kaikki miinattomat luukut. "
                + "Kun kaikki miinattomat luukut on avattu, olet voittanut. \nJos avaat miinan sisältävän "
                + "luukun, häviät. Hiiren vasemmalla painikkeella voit avata luukkuja. Hiiren oikealla "
                + "painikkeella puolestaan voit merkitä \noletettuja miinojen paikkoja, "
                + "tai poistaa kyseisen merkinnän. Jos avatusta luukusta ei paljastu miinaa, paljastuu sieltä "
                + "tyhjä luukku, jos kyseisen luukun \nviereisissä luukuissa ei ole yhtään miinaa, tai numeroarvo, "
                + "joka kertoo kuinka monta miinaa viereisissä luukuissa on. Paneelin "
                + "yläosassa on laskuri, \njoka kertoo, kuinka monta merkitsemätöntä miinaa pelikentässä on "
                + "jäljellä. Pelin voitettuasi näen pelaamiseen kuluneen ajan.",
                "Käyttöohje", JOptionPane.INFORMATION_MESSAGE);

    }
}
