package Miinaharava.Kayttoliittyma;

import Miinaharava.Sovelluslogiikka.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Tässä luokassa määritellään varsinainen pelin sisältävä frame
 *   
 */
public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;
    private JLabel laskuriTeksti;
    private long alku;

    /**
     * Metodissa asetetaan parametrina saatu Peli-rajapinnan toteuttava olio  
     * attribuuttiin peli
     * 
     * @param peli   asetetaan parametri attribuuttiin peli 
     *   
     */
    public GraafinenKayttoliittyma(Peli peli) {
        this.peli = peli;
    }

    /**
     * Tämä metodi suoritetaan ensimmäisenä. Tässä määritellään käyttöön otettava frame  
     */
    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(1200, 750));
        frame.setLocation(5, 5);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        alku = System.currentTimeMillis();
    }

    /**
     * Metodissa luodaan framen sisään asetettavat komponentit  
     */
    public void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        container.add(viestikentta(), BorderLayout.NORTH);
        container.add(new PeliPaneeli(peli, this));

    }

    /**
     * Metodi on apumetodina edelliselle metodille komponenttien kasaamisessa
     * 
     * @return palauttaa JPanelin, joka lisätään frameen
     */
    private JPanel viestikentta() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton ohjeet = new JButton("Käyttöohje");
        ohjeet.addActionListener(new KayttoOhje(this));
        JButton uusiPeli = new JButton("Uusi peli");
        uusiPeli.addActionListener(new UusiPeliKuuntelija(this));
        panel.add(uusiPeli);
        JButton lopeta = new JButton("Lopeta");
        lopeta.addActionListener(new LopetaKuuntelija(this));
        panel.add(lopeta);
        panel.add(ohjeet);
        laskuriTeksti = new JLabel("Merkitsemättömiä miinoja: " + peli.getPeliAlusta().getVielaMerkitsemattomienMiinojenMaara());
        panel.add(laskuriTeksti);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getTeksti() {
        return laskuriTeksti;
    }

    public long getAlku() {
        return alku;
    }
}
