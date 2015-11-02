package Miinaharava.Kayttoliittyma;

import Miinaharava.Sovelluslogiikka.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Tässä luokassa asetetaan pelaajalle kysymyksiä, joiden pohjalta peli luodaan. Pelaaja
 * ei pääse tästä vaiheesta eteenpäin ennen kuin antaa kelvolliset syötteet pelin luomiseksi
 * 
 */
class AloitusKysely implements Runnable {

    private Peli peli;
    private JFrame frame;

    /**
     * Metodi, joka suoritetaan ensimmäisenä. Tässä määritellään framen toiminta ja sisältö  
     */
    @Override
    public void run() {

        frame = new JFrame("Pelin määritykset");
        frame.setPreferredSize(new Dimension(500, 200));
        frame.setLocation(100, 5);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Metodissa luodaan komponentit, jotka lisätään parametrina saatuun säiliöön
     * 
     * @param container   Säiliö, johon kaikki luodut komponentit lisätään
     */
    public void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(5, 1));
        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());
        JLabel viesti = new JLabel();
        viesti.setText("Aloittaaksesi pelin, määritä haluttu kentän koko sekä miinojen määrä:");
        panel5.add(viesti);
        container.add(panel5);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JLabel leveysTeksti = new JLabel("   Kentän leveys (korkeintaan 28):     ");
        JTextField leveysKentta = new JTextField();
        panel1.add(leveysTeksti, BorderLayout.WEST);
        panel1.add(leveysKentta);
        panel1.add(new JLabel("               "), BorderLayout.EAST);
        container.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        JLabel korkeusTeksti = new JLabel("   Kentän korkeus (korkeintaan 50): ");
        JTextField korkeusKentta = new JTextField();
        panel2.add(korkeusTeksti, BorderLayout.WEST);
        panel2.add(korkeusKentta);
        panel2.add(new JLabel("               "), BorderLayout.EAST);
        container.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        JLabel miinatTeksti = new JLabel("   Miinojen määrä:                                  ");
        JTextField miinatKentta = new JTextField();
        panel3.add(miinatTeksti, BorderLayout.WEST);
        panel3.add(miinatKentta);
        panel3.add(new JLabel("               "), BorderLayout.EAST);
        container.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        JButton aloitaNappi = new JButton("Aloita peli");
        aloitaNappi.addActionListener(new AloitaNapinKuuntelija(leveysKentta, korkeusKentta, miinatKentta, peli, this));
        panel4.add(aloitaNappi);
        container.add(panel4);
    }

    public JFrame getFrame() {
        return frame;
    }
}
