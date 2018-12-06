package model;

/**
 * @author Janik Mayr on 29.11.2018
 */
public class Vermietstation {
    private String stadtcode; //ID
    private String stations_name; //ID
    private String adresse;
    private int mitarbeiter_anzahl;
    private Stadt stadt;

    public Vermietstation(String stadtcode, String stations_name, String adresse, int mitarbeiter_anzahl, Stadt stadt) {
        this.stadtcode = stadtcode;
        this.stations_name = stations_name;
        this.adresse = adresse;
        this.mitarbeiter_anzahl = mitarbeiter_anzahl;
        this.stadt = stadt;
    }

    public String getStadtcode() {
        return stadtcode;
    }

    public void setStadtcode(String stadtcode) {
        this.stadtcode = stadtcode;
    }

    public String getStations_name() {
        return stations_name;
    }

    public void setStations_name(String stations_name) {
        this.stations_name = stations_name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getMitarbeiter_anzahl() {
        return mitarbeiter_anzahl;
    }

    public void setMitarbeiter_anzahl(int mitarbeiter_anzahl) {
        this.mitarbeiter_anzahl = mitarbeiter_anzahl;
    }

    public Stadt getStadt() {
        return stadt;
    }

    public void setStadt(Stadt stadt) {
        this.stadt = stadt;
    }

    @Override
    public String toString() {
        return "Vermietstation{" +
                "stadtcode='" + stadtcode + '\'' +
                ", stations_name='" + stations_name + '\'' +
                ", adresse='" + adresse + '\'' +
                ", mitarbeiter_anzahl=" + mitarbeiter_anzahl +
                ", stadt=" + stadt +
                '}';
    }
}
