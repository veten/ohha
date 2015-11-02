package Miinaharava.Kayttoliittyma;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        AloitusKysely kysely = new AloitusKysely();
        SwingUtilities.invokeLater(kysely);

        
        // TODO standardi pelit 3 kpl radiobuttoneilla omaan frameen, jossa nappi, 
        // 'ekalla ei miinaan' toteutus..
        // jolla pääsee customeversioon.., kuvat nappeihin..
        // 10 x 10 x 10(10%), 20 x 20 x 60(15%), 28 x 50 x 280(20%)
// win-versiossa: 9x9x10(12%), 16x16x40(15%), 30x16x99(20%)
    }
}
