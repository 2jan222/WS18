package model;

/**
 * @author Janik Mayr on 29.11.2018
 */
public class Stadt {
    private String stadtcode; //P
    private String name;
    private int einwohner_anzahl;

    public Stadt(String stadtcode, String name, int einwohner_anzahl) {
        this.stadtcode = stadtcode;
        this.name = name;
        this.einwohner_anzahl = einwohner_anzahl;
    }

    public String getStadtcode() {
        return stadtcode;
    }

    public void setStadtcode(String stadtcode) {
        this.stadtcode = stadtcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEinwohner_anzahl() {
        return einwohner_anzahl;
    }

    public void setEinwohner_anzahl(int einwohner_anzahl) {
        this.einwohner_anzahl = einwohner_anzahl;
    }
}
