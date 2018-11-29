package model;

import java.util.List;

/**
 * @author Janik Mayr on 29.11.2018
 */
public class Extraausstattung {
    private Autotyp typ_bezeichnung;
    private String extras_bezeichnung;
    private double aufpreis;
    private List<Auto> autosMitAusstattung;

    public Extraausstattung(Autotyp typ_bezeichnung, String extras_bezeichnung, double aufpreis) {
        this.typ_bezeichnung = typ_bezeichnung;
        this.extras_bezeichnung = extras_bezeichnung;
        this.aufpreis = aufpreis;
    }

    public List<Auto> getAutosMitAusstattung() {
        return autosMitAusstattung;
    }

    public void setAutosMitAusstattung(List<Auto> autosMitAusstattung) {
        this.autosMitAusstattung = autosMitAusstattung;
    }

    public Autotyp getTyp_bezeichnung() {
        return typ_bezeichnung;
    }

    public void setTyp_bezeichnung(Autotyp typ_bezeichnung) {
        this.typ_bezeichnung = typ_bezeichnung;
    }

    public String getExtras_bezeichnung() {
        return extras_bezeichnung;
    }

    public void setExtras_bezeichnung(String extras_bezeichnung) {
        this.extras_bezeichnung = extras_bezeichnung;
    }

    public double getAufpreis() {
        return aufpreis;
    }

    public void setAufpreis(double aufpreis) {
        this.aufpreis = aufpreis;
    }
}
