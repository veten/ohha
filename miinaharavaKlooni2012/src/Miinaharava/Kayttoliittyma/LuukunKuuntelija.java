package Miinaharava.Kayttoliittyma;

import Miinaharava.Sovelluslogiikka.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Tässä luokassa määritellään toiminta sille kun luukun kohdalla painetaan hiiren vasenta nappia.
 * Eli toiminta luukun avaamiselle
 *   
 */
public class LuukunKuuntelija implements ActionListener {

    private GraafinenKayttoliittyma liittyma;
    private Peli peli;
    private int indeksi;
    private PeliPaneeli peliPaneeli;

    public LuukunKuuntelija(GraafinenKayttoliittyma liittyma, PeliPaneeli peliPaneeli, Peli peli, int indeksi) {

        this.liittyma = liittyma;
        this.peliPaneeli = peliPaneeli;
        this.peli = peli;
        this.indeksi = indeksi;
    }

    /**
     * Metodi tarkistaa, että käyttöliittymän kaikki napit ovat ajantasalla, eli vertaa 
     * nappeja pelin piilotetun peliAlustan nappien statukseen, ja tarvittaessa päivittää,
     * eli avaa käyttöliittymän luukkuja
     */
    private void tarkastaKaikkiNapit() {
        for (int i = 0; i < peliPaneeli.getNapit().length; i++) {
            Luukku luukku = peli.getPiilotettuAlusta().get(i);
            String luukunTuloste = luukku.getTuloste();
            peliPaneeli.getNapit()[i].setText(luukunTuloste);
            if (luukku == Luukku.PIILOTETTU) {
                peliPaneeli.getNapit()[i].setBackground(Color.WHITE);
            } else if (luukku == Luukku.MERKITTY) {
                peliPaneeli.getNapit()[i].setBackground(Color.GREEN);
            } else if (luukku == Luukku.MIINA) {
                peliPaneeli.getNapit()[i].setBackground(Color.RED);
            } else {
                peliPaneeli.getNapit()[i].setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    /**
     * Metodi avaa kyseisen luukun ja päivittää liittymän ja pelin arvot, tai heittää inforuudussa
     * virheilmon tai tiedote ilmon tarvittaessa
     *   
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!peli.peliLoppu()) {
            if (!peli.luukkuAvattu(indeksi)) {

                if (peli.getPiilotettuAlusta().get(indeksi) == Luukku.MERKITTY) {
                    peli.getPeliAlusta().kasvataMerkittyjenMiinojenLaskuria(1);
                    peliPaneeli.getLiittyma().getTeksti().setText("Merkitsemättömiä miinoja: " + peli.getPeliAlusta().getVielaMerkitsemattomienMiinojenMaara());
                }
                Luukku luukku = peli.avaaLuukku(indeksi);
                peliPaneeli.getNapit()[indeksi].setText(luukku.getTuloste());
                if (luukku == Luukku.MIINA) {
                    peliPaneeli.getNapit()[indeksi].setBackground(Color.red);
                } else {
                    peliPaneeli.getNapit()[indeksi].setBackground(Color.LIGHT_GRAY);
                    if (luukku == Luukku.VIERESSA0) {
                        peli.avaaViereisetRuudut(indeksi);
                        tarkastaKaikkiNapit();
                    }
                }

                if (peli.peliLoppu()) {
                    long aika = System.currentTimeMillis() - liittyma.getAlku();
                    if (peli.kaikkiAvattu()) {
                        peli.paljastaLiput();

                        JOptionPane.showMessageDialog(liittyma.getFrame(),
                                "Onneksi olkoon. Voitit! \nAikasi oli: " + aika / 1000 + " sekuntia",
                                "Peli loppui", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        peli.paljastaMiinat();

                        JOptionPane.showMessageDialog(liittyma.getFrame(),
                                "Osuit miinaan. Hävisit!",
                                "Peli loppui", JOptionPane.INFORMATION_MESSAGE);
                    }
                    tarkastaKaikkiNapit();
                }
            }
        } else {
            JOptionPane.showMessageDialog(liittyma.getFrame(),
                    "Peli on jo loppunut. Aloittaaksesi uuden peli, paina 'Uusi peli' -painiketta "
                    + "ja lopettaaksesi pelaamisen, paina 'Lopeta'-painiketta",
                    "Peli loppui jo", JOptionPane.INFORMATION_MESSAGE);
         }
    }
}