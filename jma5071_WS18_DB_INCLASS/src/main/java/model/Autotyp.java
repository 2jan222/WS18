package model;

/**
 * @author Janik Mayr on 29.11.2018
 */
public class Autotyp {
    private String typ_bezeichnung; //P
    private double benzinverbrauch;
    private String kategorie_bezeichnung;
    private Stadt stadt;

    public String getTyp_bezeichnung() {
        return typ_bezeichnung;
    }

    public void setTyp_bezeichnung(String typ_bezeichnung) {
        this.typ_bezeichnung = typ_bezeichnung;
    }

    public double getBenzinverbrauch() {
        return benzinverbrauch;
    }

    public void setBenzinverbrauch(double benzinverbrauch) {
        this.benzinverbrauch = benzinverbrauch;
    }

    public String getKategorie_bezeichnung() {
        return kategorie_bezeichnung;
    }

    public void setKategorie_bezeichnung(String kategorie_bezeichnung) {
        this.kategorie_bezeichnung = kategorie_bezeichnung;
    }

    public Stadt getStadt() {
        return stadt;
    }

    public void setStadt(Stadt stadt) {
        this.stadt = stadt;
    }
}
