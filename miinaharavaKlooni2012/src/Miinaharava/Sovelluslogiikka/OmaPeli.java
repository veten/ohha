package Miinaharava.Sovelluslogiikka;

import java.util.*;

/**
 * Luokka peli sisältää pelialustan ja listan, jossa on sama määrä luukkuja kuin
 * pelialustassa. Listassa on aluksi kaikki luukut peitetty, ja pelin edetessä
 * kun luukkuja avataan, luukkujen paikalle laitetaan pelialustassa vastaavassa 
 * kohdassa oleva tieto. Tämä luokka toteuttaa rajapinnnan Peli
 * 
 *
 */
public class OmaPeli implements Peli {

    /**
     * peliAlusta on pelin käyttämä pelikenttä, jonka ilmentymä luodaan tässä luokassa
     */
    private PeliAlusta peliAlusta;
    /**
     * piilotettuAlusta on tässä luokassa luotava uusi lista luukkuja, jotka aluksi ovat arvoltaan
     * piilotettuja, ja pelin edetessä luukkujen arvoja päivitetään vertaamalla peliAlustan 
     * vastaavissa kohdissa olevien luukkujen arvoihin
     * 
     */
    private List<Luukku> piilotettuAlusta;

    /**
     * Konstruktorissa luodaan uusi peliAlusta, sekä piilotettu alusta, jonka kaikkiin luukkuihin
     * asetetaan arvoksi piilotettu
     * 
     * @param leveys   Pelikentän leveys
     * @param korkeus   Pelikentän korkeus
     * @param miinat   Penlikentän sisältämien miinojen määrä
     * 
     * @see PeliAlusta
     */
    public OmaPeli(int leveys, int korkeus, int miinat) {

        this.peliAlusta = new PeliAlusta(leveys, korkeus, miinat);
        this.piilotettuAlusta = new ArrayList<Luukku>();
        for (int i = 0; i < leveys * korkeus; i++) {
            this.piilotettuAlusta.add(Luukku.PIILOTETTU);
        }
    }

    /**
     * Metodi palauttaa piilotetunAlustan, eli listan luukkuja, joiden arvot ovat vielä 
     * osin pelaajalta piilotettuna
     * 
     * @return palauttaa listan luukkuja, joissa vielä osin piilotetut luukkujen arvot
     */
    @Override
    public List<Luukku> getPiilotettuAlusta() {
        return piilotettuAlusta;
    }

    /**
     * Metodi palauttaa peliAlustan, eli kaikki pelikentän tiedot sisältävän olion
     * 
     * @see PeliAlusta
     * 
     * @return palauttaa pelikentän tiedot sisältävän olion
     */
    @Override
    public PeliAlusta getPeliAlusta() {
        return peliAlusta;
    }

    /**
     * Metodi avaa indeksikohdan viereiset luukut, ja jos niistä löytyy luukkuja, joiden vieressä
     * ei ole yhtään miinaa, avaa metodi myös kyseisen luukun viereiset luukut. Kyseessä on siis 
     * rekursiivinen metodi, jonka tarkoitus on avata isompi alue, riippuen siitä kuinka moneen
     * 'nolla'-arvoiseen luukkuun törmätään. Tätä metodia kustustaan siinä tapauksessa, että
     * pelaaja avaa luukun, jonka alta paljastuu 'nolla'-arvo.
     * 
     * @param indeksi   Indeksikohta, jonka viereisiä luukkuja avataan
     * 
     */
    @Override
    public void avaaViereisetRuudut(int indeksi) {
        for (int i : this.peliAlusta.kaikkiViereisetRuudutTaulukossa(indeksi)) {
            if (this.piilotettuAlusta.get(i) == Luukku.PIILOTETTU) {
                this.piilotettuAlusta.set(i, this.peliAlusta.getLuukut().get(i));

                if (this.peliAlusta.getLuukut().get(i) == Luukku.VIERESSA0) {
                    avaaViereisetRuudut(i);
                }
            }
        }
    }

    /**
     * Metodi avaa parametrina saadun indeksikohdan luukun piilotetusta alustasta, ja palauttaa
     * kyseisen avatun luukun sisällön
     * 
     * @param indeksi   Avattavan luukun indeksikohta
     *
     * @return palauttaa pelikentän luukku-listalla kyseisessä kohdassa olevan luukun
     */
    @Override
    public Luukku avaaLuukku(int indeksi) {
        this.piilotettuAlusta.set(indeksi, this.peliAlusta.getLuukut().get(indeksi));
        return this.peliAlusta.getLuukut().get(indeksi);
    }

        /**
     * Metodi paljastaa eli avaa kaikkien pelikentän miinojen paikat. Metodia kutsutaan, kun 
     * pelaaja on avannut miinan sisältävän luukun, jolloin pelin lopuksi näytetään pelaajalle
     * kaikkien miinojen paikat
     * 
     */
    @Override
    public void paljastaMiinat() {
        for (int i = 0; i < this.piilotettuAlusta.size(); i++) {
            if (this.peliAlusta.getLuukut().get(i) == Luukku.MIINA) {
                this.piilotettuAlusta.set(i, this.peliAlusta.getLuukut().get(i));
            }
        }
    }

        /**
     * Metodi palauttaa totuusarvon, joka kertoo, onko kyseinen luukku jo avattu
     * 
     * @param indeksi   Indeksikohta, jonka aukiolevuutta tarkastellaan
     * 
     * @return palauttaa totuusarvona tiedon siitä, oliko kyseinen luukku jo avattu
     */
    @Override
    public boolean luukkuAvattu(int indeksi) {
        if (this.piilotettuAlusta.get(indeksi) != Luukku.PIILOTETTU && this.piilotettuAlusta.get(indeksi) != Luukku.MERKITTY) {
            return true;
        }
        return false;
    }

        /**
     * Metodi palauttaa totuusarvon, joka kertoo, onko kaikki piilotetun alustan miinattomat 
     * luukut avattu
     * 
     * @return palauttaa totuusarvona tiedon siitä, onko kaikki miinattomat luukut avattu
     */
    @Override
    public boolean kaikkiAvattu() {
        int laskuri = 0;
        for (int i = 0; i < this.piilotettuAlusta.size(); i++) {
            if (this.peliAlusta.getLuukut().get(i) != Luukku.MIINA && this.luukkuAvattu(i)) {
                laskuri++;
            }
        }
        if (laskuri == this.piilotettuAlusta.size() - this.peliAlusta.getMiinojenMaara()) {
            return true;
        }
        return false;
    }

        /**
     * Metodi merkitsee lipulla kaikkien pelikentän miinojen paikat. Metodia kutsutaan, kun 
     * pelaaja on avannut kaikki miinattomat luukut ja voittanut pelin, jolloin pelin 
     * lopuksi näytetään pelaajalle vielä kaikkien miinojen paikat
     * 
     */
    @Override
    public void paljastaLiput() {
        for (int i = 0; i < this.piilotettuAlusta.size(); i++) {
            if (this.peliAlusta.getLuukut().get(i) == Luukku.MIINA) {
                this.piilotettuAlusta.set(i, Luukku.MERKITTY);
            }
        }

    }

     /**
     * Metodi merkitsee lipulla kyseisen luukun. Metodia kutsutaan kun pelaaja haluaa merkitä
     * luukun, jonka takana uskoo olevan miinan. Pelaaja voi myös poistaa tekemänsä merkinnän, 
     * jolloin metodia kutsutaan uudestaan
     * 
     * @param indeksi   Indeksikohta, joka merkitään lipulla, tai jos luukku on jo merkitty, 
     * poistetaan merkintä
     * 
     */
    @Override
    public void merkitseLipullaTaiPoistaMerkinta(int indeksi) {
        if (this.piilotettuAlusta.get(indeksi) == Luukku.PIILOTETTU) {
            this.piilotettuAlusta.set(indeksi, Luukku.MERKITTY);
            this.peliAlusta.kasvataMerkittyjenMiinojenLaskuria(-1);
        } else if (this.piilotettuAlusta.get(indeksi) == Luukku.MERKITTY) {
            this.piilotettuAlusta.set(indeksi, Luukku.PIILOTETTU);
            this.peliAlusta.kasvataMerkittyjenMiinojenLaskuria(1);
        } 
    }

     /**
     * Metodi palauttaa tiedon siitä, onko peli loppunut käyttääen hyväkseen tietoja siitä, 
     * onko miinallista luukkua avattu tai onko kaikki miinattomat luukut avattu
     * 
     * @return palauttaa totuusarvona tiedon siitä, onko peli loppunut
     */
    @Override
    public boolean peliLoppu() {
        for (Luukku l : this.piilotettuAlusta) {
            if (l == Luukku.MIINA) {
                return true;
            }
        }
        if (this.kaikkiAvattu()) {
            return true;
        }
        return false;
    }
}
