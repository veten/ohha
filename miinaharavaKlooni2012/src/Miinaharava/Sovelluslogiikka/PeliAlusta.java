package Miinaharava.Sovelluslogiikka;


import java.util.*;

/**
 * Luokassa luodaan pelialusta, jossa määritellään alustan koko
 * ja miinojen määrä. Pelilaudalla olevat luukut on sijoitettu Luukku-olioista
 * koostuvaan listaan. Tässä luokassa arvotaan miinoille paikat, ja asetetaan
 * muihin ruutuihin miinoista kertovat numerot.
 * 
 * Lisäksi pelialustaan tallettuu laskuri, joka kertoo 
 * vielä merkitsemättömien miinojen määrän.
 * 
 * 
 */
public class PeliAlusta {
    
    /**
     * Pelikentän leveyden ilmoittava muuttuja
     */
    private int kentanLeveys;
    
        /**
     * Pelikentän korkeuden ilmoittava muuttuja
     */
    private int kentanKorkeus;
    
        /**
     * Pelikentässä olevien miinojen määrän ilmoittava muuttuja
     */
    private int miinojenMaara;
    
        /**
     * Muuttuja joka ilmoittaa pelissä, kuinka monta miinaa on vielä merkitsemättä
     */
    private int vielaMerkitsemattomienMiinojenMaara;
    
        /**
     * Lista johon on tallennettu kaikki pelikentän luukut
     */
    private List<Luukku> luukut;

     /**
     * Konstruktorissa asetetaan attribuuttien arvot, sekä asetetaan luukku-listalle ensin 
     * miinojen ja nollien paikat ja tämän jälkeen loput luukkujen arvot
     * 
     * @param kentanLeveys   asetetaan kentän leveys
     * @param kentanKorkeus   asetetaan kentän korkeus
     * @param miinojenMaara   asetetaan miinojen lukumäärä
     * 
     */
    public PeliAlusta(int kentanLeveys, int kentanKorkeus, int miinojenMaara) {
        this.kentanLeveys = kentanLeveys;
        this.kentanKorkeus = kentanKorkeus;
        this.miinojenMaara = miinojenMaara;
        this.luukut = new ArrayList<Luukku>();
        this.vielaMerkitsemattomienMiinojenMaara = miinojenMaara;
        this.asetaMiinatJaNollat();
        this.asetaKaikkiNumerot();
    }

    /**
     * Metodi asettaa tyhjään listaan tarvittavan määrän miinoja
     * ja lopuille paikoille nollia. Lopuksi lista sekoitetaan, 
     * jolloin saadaan miinojen lopulliset paikat
     *
     */
    private void asetaMiinatJaNollat() {
        int laskuri = 0;
        while (laskuri < this.miinojenMaara) {
            this.luukut.add(Luukku.MIINA);
            laskuri++;
        }
        for (int i = 0; i < (this.kentanKorkeus * this.kentanLeveys) - this.miinojenMaara; i++) {
            this.luukut.add(Luukku.VIERESSA0);
        }
        Collections.shuffle(this.luukut);
    }

        /**
     * Metodi palauttaa listan, jossa on kaikki pelialustan luukut
     * 
     * @return kaikki pelin luukut listassa
     */
    public List<Luukku> getLuukut() {
        return this.luukut;
    }

        /**
     * Metodi palauttaa pelikentässä olevien miinojen määrän
     * 
     * @return miinojen määrä
     */
    public int getMiinojenMaara() {
        return miinojenMaara;
    }

        /**
     * Metodi palauttaa vielä merkitsemättömien miinojen määrän
     * 
     * @return merkitsemättömien miinojen määrä
     */
    public int getVielaMerkitsemattomienMiinojenMaara() {
        return vielaMerkitsemattomienMiinojenMaara;
    }

        /**
     * Metodi palauttaa pelikentän leveyden
     * 
     * @return pelikentän leveys
     */
    public int getKentanLeveys() {
        return this.kentanLeveys;
    }

        /**
     * Metodi palauttaa pelikentän korkeuden
     * 
     * @return pelikentän korkeus
     */
    public int getKentanKorkeus() {
        return kentanKorkeus;
    }

    /**
     * Metodi kasvattaa vielä merkitsemättömien miinojen laskuria annetulla määrällä
     *
     * @param   maara   laskuria kasvatetaan annetun määrän verran
     * 
     */
    public void kasvataMerkittyjenMiinojenLaskuria(int maara) {
        this.vielaMerkitsemattomienMiinojenMaara += maara;
    }

    /**
     * Metodi tarkistaa, onko pelialustassa olevat kaksi indeksiä vierekkäiset. Tässä
     * metodissa oletetaan, että annetut indeksikohdat pysyvät taulukon sisällä. Vastuu 
     * tämän toteutumisesta on jätetty kutsuvalle metodille
     *
     * @param   indeksi   Kohta, jonka viereisiä luukkuja tarkastellaan
     * @param   viereinen    Kohta, jonka viereisyyttä indeksiin verrataan
     * 
     * @see PeliAlusta#kaikkiViereisetRuudutTaulukossa(int) 
     * 
     * @return totuusarvo, joka kertoo, ovatko kyseiset indeksikohdat alustassa vierekkäiset
     */
    public boolean onViereiset(int indeksi, int viereinen) {
        boolean palautettava = false;
        if (viereinen == indeksi - kentanLeveys || viereinen == indeksi - kentanLeveys - 1
                || viereinen == indeksi - kentanLeveys + 1 || viereinen == indeksi - 1
                || viereinen == indeksi + 1 || viereinen == indeksi + kentanLeveys - 1
                || viereinen == indeksi + kentanLeveys + 1 || viereinen == indeksi + kentanLeveys) {
            palautettava = true;
        }
        if (indeksi % kentanLeveys == kentanLeveys - 1 && kentanLeveys > 2 && (viereinen == indeksi + 1
                || viereinen == indeksi - kentanLeveys + 1 || viereinen == indeksi + kentanLeveys + 1)) {
            palautettava = false;
        }
        if (indeksi % kentanLeveys == 0 && kentanLeveys > 2 && (viereinen == indeksi - 1
                || viereinen == indeksi - kentanLeveys - 1 || viereinen == indeksi + kentanLeveys - 1)) {
            palautettava = false;
        }

        return palautettava;
    }

    /**
     * Metodi etsii kyseisen indeksikohdan viereiset indeksit ja palauttaa ne taulukossa
     *
     * @param   indeksi   Kohta, jota tarkastellaan
     * 
     *
     * @return listana ne indeksikohdat, jotka ovat indeksin vieressä tässä pelikentässä
     */
    public List<Integer> kaikkiViereisetRuudutTaulukossa(int indeksi) {
        ArrayList<Integer> palautettava = new ArrayList<Integer>();

        for (int i = 0; i < luukut.size(); i++) {
            if (onViereiset(indeksi, i)) {
                palautettava.add(i);
            }
        }
        return palautettava;
    }

    /**
     * Metodi muuntaa luvut luukku-arvoiksi
     *
     * @param   luku   Annettu luku, joka muutetaan vastaavaksi luukun arvoksi
     * 
     * @return luukuksi muutettu luku
     */
    public Luukku muunnaLukuLuukuksi(int luku) {
        if (luku == 1) {
            return Luukku.VIERESSA1;
        } else if (luku == 2) {
            return Luukku.VIERESSA2;
        } else if (luku == 3) {
            return Luukku.VIERESSA3;
        } else if (luku == 4) {
            return Luukku.VIERESSA4;
        } else if (luku == 5) {
            return Luukku.VIERESSA5;
        } else if (luku == 6) {
            return Luukku.VIERESSA6;
        } else if (luku == 7) {
            return Luukku.VIERESSA7;
        } else if (luku == 8) {
            return Luukku.VIERESSA8;
        } else if (luku == 0) {
            return Luukku.VIERESSA0;
        } else {
            return Luukku.MIINA;
        }
    }

    /**
     * Metodi asettaa listaan, johon on tähän mennessä asetettu vain miinat ja
     * nollia, kaikki loput luukku-tyyppiset arvot omille paikoilleen. Luukku-arvot
     * siis kertovat, kuinka monessa luukun viereisessä luukussa on miina
     *
     * @see    PeliAlusta#asetaMiinatJaNollat() 
     *
     */
    private void asetaKaikkiNumerot() {
        for (int i = 0; i < this.luukut.size(); i++) {
            int laskuri = 0;
            if (this.luukut.get(i) != Luukku.MIINA) {
                for (int j : this.kaikkiViereisetRuudutTaulukossa(i)) {
                    if (this.luukut.get(j) == Luukku.MIINA) {
                        laskuri++;
                    }
                }
                this.luukut.set(i, this.muunnaLukuLuukuksi(laskuri));
            }
        }
    }

}
