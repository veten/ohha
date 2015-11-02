package Miinaharava.Sovelluslogiikka;

/**
 * Tässä luokassa määritellään luukkujen mahdolliset sisällöt, eli numeroarvo,
 * joka kertoo monessako viereisessä luukussa on miina, tai jos luukku on merkitty, 
 * tai vielä luukku avaamatta, tai jos luukussa on miina.
 *   
 */

public enum Luukku {

    /**
     * Luukun arvo, joka kertoo luukun viereisissä luukuissa olevien miinojen määrä
     */
    VIERESSA0(""),
    
    /**
     * Luukun arvo, joka kertoo luukun viereisissä luukuissa olevien miinojen määrä
     */    
    VIERESSA1("1"),
    
    /**
     * Luukun arvo, joka kertoo luukun viereisissä luukuissa olevien miinojen määrä
     */
    VIERESSA2("2"),
    
    /**
     * Luukun arvo, joka kertoo luukun viereisissä luukuissa olevien miinojen määrä
     */
    VIERESSA3("3"),
    
    /**
     * Luukun arvo, joka kertoo luukun viereisissä luukuissa olevien miinojen määrä
     */
    VIERESSA4("4"),
    
    /**
     * Luukun arvo, joka kertoo luukun viereisissä luukuissa olevien miinojen määrä
     */
    VIERESSA5("5"),
    
    /**
     * Luukun arvo, joka kertoo luukun viereisissä luukuissa olevien miinojen määrä
     */
    VIERESSA6("6"),
    
    /**
     * Luukun arvo, joka kertoo luukun viereisissä luukuissa olevien miinojen määrä
     */
    VIERESSA7("7"),
    
    /**
     * Luukun arvo, joka kertoo luukun viereisissä luukuissa olevien miinojen määrä
     */
    VIERESSA8("8"),
    
    /**
     * Luukun arvo, joka kertoo, että luukussa on miina
     */
    MIINA("*"),
    
    /**
     * Luukun arvo, joka kertoo, että luukku on vielä avaamatta, eli piilotettuna
     */
    PIILOTETTU(""),
    
    /**
     * Luukun arvo, joka kertoo, että luukku on pelaajan toimesta merkitty mahdollisena miinan olinpaikkana
     */
    MERKITTY("L");
    
    /**
     * Muuttuja johon luukun tulostettava arvo tallennetaan
     */
    private String tuloste;

     /**
     * Konstruktorissa liitetään luukkuun luukun arvo
     * 
     * @param tuloste   asetetaan luukulle tunnisteeksi merkkijono, joka saadaan haettua 
     * seuraavalla metodilla
     * 
     * @see Luukku#getTuloste() 
     */
    private Luukku(String tuloste) {
        this.tuloste = tuloste;
    }
    
    /**
     * Metodi palauttaa Luukun arvon merkkijonona
     * 
     * @return Luukun arvo merkkijonona
     */
    public String getTuloste() {
        return tuloste;
    }
}
