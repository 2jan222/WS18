package model;

import jdbc.PojoBase;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Janik Mayr on 29.11.2018
 */
public class Auto extends PojoBase {
    private String kennzeichen;
    private int km_stand;
    private String autofarbe;
    private Vermietstation vermietstation;
    private Autotyp typ_bezeichnung;
    private List<Extraausstattung> extraausstattungen = new LinkedList<>();

    public Auto(String kennzeichen, int km_stand, String autofarbe, Vermietstation vermietstation, Autotyp typ_bezeichnung, Extraausstattung... extraausstattung) {
        this.kennzeichen = kennzeichen;
        this.km_stand = km_stand;
        this.autofarbe = autofarbe;
        this.vermietstation = vermietstation;
        this.typ_bezeichnung = typ_bezeichnung;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public int getKm_stand() {
        return km_stand;
    }

    public void setKm_stand(int km_stand) {
        this.km_stand = km_stand;
    }

    public String getAutofarbe() {
        return autofarbe;
    }

    public void setAutofarbe(String autofarbe) {
        this.autofarbe = autofarbe;
    }

    public Vermietstation getVermietstation() {
        return vermietstation;
    }

    public void setVermietstation(Vermietstation vermietstation) {
        this.vermietstation = vermietstation;
    }

    public Autotyp getTyp_bezeichnung() {
        return typ_bezeichnung;
    }

    public void setTyp_bezeichnung(Autotyp typ_bezeichnung) {
        this.typ_bezeichnung = typ_bezeichnung;
    }


    @Override
    public String toString() {
        return "Auto{" +
                "kennzeichen='" + kennzeichen + '\'' +
                ", km_stand=" + km_stand +
                ", autofarbe=" + autofarbe +
                ", vermietstation=" + vermietstation +
                ", typ_bezeichnung=" + typ_bezeichnung +
                ", extraausstattungen=" + extraausstattungen +
                '}';
    }
}
