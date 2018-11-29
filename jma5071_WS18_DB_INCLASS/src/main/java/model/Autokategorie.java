package model;

/**
 * @author Janik Mayr on 29.11.2018
 */
public class Autokategorie {
    private String kategorie_bezeichnung;
    private double grundtarif;
    private double km_preis;

    public Autokategorie(String kategorie_bezeichnung, double grundtarif, double km_preis) {
        this.kategorie_bezeichnung = kategorie_bezeichnung;
        this.grundtarif = grundtarif;
        this.km_preis = km_preis;
    }

    public String getKategorie_bezeichnung() {
        return kategorie_bezeichnung;
    }

    public void setKategorie_bezeichnung(String kategorie_bezeichnung) {
        this.kategorie_bezeichnung = kategorie_bezeichnung;
    }

    public double getGrundtarif() {
        return grundtarif;
    }

    public void setGrundtarif(double grundtarif) {
        this.grundtarif = grundtarif;
    }

    public double getKm_preis() {
        return km_preis;
    }

    public void setKm_preis(double km_preis) {
        this.km_preis = km_preis;
    }
}
