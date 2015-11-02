package Miinaharava.Kayttoliittyma;

import Miinaharava.Sovelluslogiikka.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Tässä luokassa määritellään toiminta joka tapahtuu kun luukun päällä painetaan hiiren oikeaa
 * painiketta.
 *   
 */
public class HiirenOikeanPainikkeenKuuntelija implements MouseListener {

    private Peli peli;
    private int indeksi;
    private PeliPaneeli peliPaneeli;

    public HiirenOikeanPainikkeenKuuntelija(PeliPaneeli peliPaneeli, Peli peli, int indeksi) {
        this.peliPaneeli = peliPaneeli;
        this.peli = peli;
        this.indeksi = indeksi;
    }

    /**
     * Metodi tekee luukun merkitsemis, tai merkinnänperuutustoiminnon luukulle. Eli päivitetään 
     * sovelluslogiikalle kyseisen luukun merkintä tai merkinnän poisto, sekä käyttöliittymään 
     * kyseisen luukun merkintä
     *   
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (!peli.peliLoppu()) {
            if (e.getButton() == MouseEvent.BUTTON3) {

                if (!peli.luukkuAvattu(indeksi)) {
                    if (peli.getPiilotettuAlusta().get(indeksi) == Luukku.PIILOTETTU) {
                        peliPaneeli.getNapit()[indeksi].setText(Luukku.MERKITTY.getTuloste());
                        peliPaneeli.getNapit()[indeksi].setBackground(Color.GREEN);
                        peli.merkitseLipullaTaiPoistaMerkinta(indeksi);
                        peliPaneeli.getLiittyma().getTeksti().setText("Merkitsemättömiä miinoja: " + peli.getPeliAlusta().getVielaMerkitsemattomienMiinojenMaara());
                    } else {
                        peliPaneeli.getNapit()[indeksi].setText(Luukku.PIILOTETTU.getTuloste());
                        peliPaneeli.getNapit()[indeksi].setBackground(Color.WHITE);
                        peli.merkitseLipullaTaiPoistaMerkinta(indeksi);
                        peliPaneeli.getLiittyma().getTeksti().setText("Merkitsemättömiä miinoja: " + peli.getPeliAlusta().getVielaMerkitsemattomienMiinojenMaara());
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
