package Miinaharava.Sovelluslogiikka;

import java.util.List;

/**
 * Peli-rajapinta on ainoa luokka, jota käyttöliittymä-pakkaus käyttää. Kun varsinainen 
 * peli luodaan, luodaan se tämän rajapinnan toteuttamasta luokasta, mutta sitä käytetään 
 * aina Peli-rajapinnan kautta
 * 
 */
public interface Peli {

        /**
     * Metodi palauttaa totuusarvon, joka kertoo, onko peli loppunut
     * 
     * @return totuusarvona tieto pelin loppumisesta
     */
    boolean peliLoppu();

        /**
     * Metodi merkitsee lipulla tai poistaa kyseisen merkinnän luukusta
     * 
     * @param indeksi   Indeksikohta määrittää luukun, joka merkitään, tai poistetaan merkintä, 
     * jos luukku oli jo merkitty
     */
    void merkitseLipullaTaiPoistaMerkinta(int indeksi);

     /**
     * Metodi paljastaa kaikkien miinojen paikat lipulla
     * 
     */
    void paljastaLiput();

     /**
     * Metodi tarkistaa, onko kaikki miinattomat luukut avattu
     * 
     * @return palauttaa totuusarvona tiedon siitä, onko kaikki miinattomat luukut avattu
     */
    boolean kaikkiAvattu();

     /**
     * Metodi kertoo, onko kyseinen luukku avattu
     * 
     * @param indeksi   Indeksikohta, jota tarkastellaan
     * 
     * @return palauttaa totuusarvona tiedon siitä, onko kyseinen luukku avattu
     */
    boolean luukkuAvattu(int indeksi);

     /**
     * Metodi paljastaa kaikki luukut, joiden takana on miina
     * 
     */
    void paljastaMiinat();

     /**
     * Metodi avaa luukun, eli muuntaa piilotetun listan luukun arvon vastaavaksi peliAlusta
     * luukun arvoksi
     * 
     * @param indeksi   Indeksikohta, jota tarkastellaan
     * 
     * @return palauttaa peliAlustan kyseisen kohdan luukun
     */
    Luukku avaaLuukku(int indeksi);

     /**
     * Metodi avaa kaikki kyseisen kohdan ympärillä olevat luukut, ja jos sieltä paljastuu 
     * 'nolla'-arvoisia luukkuja, avaa metodi myös näiden ympärillä olevat luukut
     * 
     * @param indeksi   Indeksikohta, jota tarkastellaan
     */
    void avaaViereisetRuudut(int indeksi);

     /**
     * Metodi palauttaa pelin käyttämän pelialustan, jossa on siis kaikki pelikentän tiedot
     * 
     * @return palauttaa peliAlusta olion, jota peli käyttää
     */
    PeliAlusta getPeliAlusta();

     /**
     * Metodi palauttaa pelin käyttämän luukku-listan, joka on pelin alussa täyttä 
     * piilotettuja-luukkuja, joita pelin edetessä avataan 
     * 
     * @return palauttaa listan luukkuja, joiden arvot pelaaja 'näkee' eli pelin alussa kaikki 
     * luukut arvoilla 'piilotettu'
     */
    List<Luukku> getPiilotettuAlusta();
}
