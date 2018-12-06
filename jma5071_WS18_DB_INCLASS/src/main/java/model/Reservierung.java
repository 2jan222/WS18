package model;

import jdbc.PojoBase;

import java.time.LocalDateTime;

/**
 * @author Janik Mayr on 29.11.2018
 */
public class Reservierung extends PojoBase {
    private Vermietstation vermietstation; //P
    private String reservierungs_nr; //P
    private LocalDateTime anfangsdatum;
    private LocalDateTime enddatum;
    private Kunde kunde;
    private Autokategorie autokategorie;

    public Vermietstation getVermietstation() {
        return vermietstation;
    }

    public void setVermietstation(Vermietstation vermietstation) {
        this.vermietstation = vermietstation;
    }

    public String getReservierungs_nr() {
        return reservierungs_nr;
    }

    public void setReservierungs_nr(String reservierungs_nr) {
        this.reservierungs_nr = reservierungs_nr;
    }

    public LocalDateTime getAnfangsdatum() {
        return anfangsdatum;
    }

    public void setAnfangsdatum(LocalDateTime anfangsdatum) {
        this.anfangsdatum = anfangsdatum;
    }

    public LocalDateTime getEnddatum() {
        return enddatum;
    }

    public void setEnddatum(LocalDateTime enddatum) {
        this.enddatum = enddatum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Autokategorie getAutokategorie() {
        return autokategorie;
    }

    public void setAutokategorie(Autokategorie autokategorie) {
        this.autokategorie = autokategorie;
    }

    @Override
    public String toString() {
        return "Reservierung{" +
                "vermietstation=" + vermietstation +
                ", reservierungs_nr='" + reservierungs_nr + '\'' +
                ", anfangsdatum=" + anfangsdatum +
                ", enddatum=" + enddatum +
                ", kunde=" + kunde +
                ", autokategorie=" + autokategorie +
                '}';
    }
}
