package Miinaharava.Kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tässä luokassa määritellään Lopeta-napin toiminnallisuus
 *   
 */
public class LopetaKuuntelija implements ActionListener {

    private GraafinenKayttoliittyma liittyma;

    public LopetaKuuntelija(GraafinenKayttoliittyma liittyma) {
        this.liittyma = liittyma;
    }

    /**
     * Metodi sulkee käyttöliittymän ja lopettaa ohjelman ajon  
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        liittyma.getFrame().setVisible(false);
        liittyma.getFrame().dispose();

    }
}
