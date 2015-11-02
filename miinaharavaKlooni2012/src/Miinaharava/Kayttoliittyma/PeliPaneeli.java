package Miinaharava.Kayttoliittyma;

import Miinaharava.Sovelluslogiikka.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Tässä luokassa määritellään käyttöliittymän osana oleva pelipaneeli, joka on 
 * osana framea ja sisältää vain avattavat luukut. Tämän luokan ilmentymä lisätään
 * osaksi framea, johon kuuluu myös muut painikkeet
 *   
 */
public class PeliPaneeli extends JPanel {

    private Peli peli;
    private JButton[] napit;
    private GraafinenKayttoliittyma liittyma;

    /**
     * Konstruktorissa määritellään haluttu paneeli ja lisätään siihen kaikki 'luukut'  
     */
    public PeliPaneeli(Peli peli, GraafinenKayttoliittyma liittyma) {
        super(new GridLayout(peli.getPeliAlusta().getKentanKorkeus(), peli.getPeliAlusta().getKentanLeveys()));
        this.peli = peli;
        this.liittyma = liittyma;
        this.napit = new JButton[this.peli.getPiilotettuAlusta().size()];
        setPreferredSize(new Dimension(peli.getPeliAlusta().getKentanLeveys() * 50, peli.getPeliAlusta().getKentanKorkeus() * 40));
        luoKomponentit();
    }

    /**
     * Metodissa luodaan alustaan lisättävät komponentit, eli haluttu määrä 'luukkuja'  
     */
    private void luoKomponentit() {

        for (int i = 0; i < peli.getPiilotettuAlusta().size(); i++) {
            napit[i] = new JButton();
            napit[i].setBackground(Color.WHITE);
            napit[i].addActionListener(new LuukunKuuntelija(liittyma, this, peli, i));
            napit[i].addMouseListener(new HiirenOikeanPainikkeenKuuntelija(this, peli, i));
            add(napit[i]);
        }
    }

    public JButton[] getNapit() {
        return napit;
    }

    public GraafinenKayttoliittyma getLiittyma() {
        return liittyma;
    }
}
