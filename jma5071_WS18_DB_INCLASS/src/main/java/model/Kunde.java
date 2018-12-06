package model;

import jdbc.PojoBase;

/**
 * @author Janik Mayr on 29.11.2018
 */
public class Kunde extends PojoBase {
    private String fuehrerschein_nummer; //P
    private String kunde_name;
    private String anschrift;

    public Kunde(String fuehrerschein_nummer, String kunde_name, String anschrift) {
        this.fuehrerschein_nummer = fuehrerschein_nummer;
        this.kunde_name = kunde_name;
        this.anschrift = anschrift;
    }

    public String getFuehrerschein_nummer() {
        return fuehrerschein_nummer;
    }

    public void setFuehrerschein_nummer(String fuehrerschein_nummer) {
        this.fuehrerschein_nummer = fuehrerschein_nummer;
    }

    public String getKunde_name() {
        return kunde_name;
    }

    public void setKunde_name(String kunde_name) {
        this.kunde_name = kunde_name;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "fuehrerschein_nummer='" + fuehrerschein_nummer + '\'' +
                ", kunde_name='" + kunde_name + '\'' +
                ", anschrift='" + anschrift + '\'' +
                '}';
    }
}
