package model;

/**
 * @author Janik Mayr on 29.11.2018
 */
public class Mietvertrag {
    private Reservierung reservierung;
    private int km_stand_uebergabe;
    private int km_stand_rueckgabe;
    private Auto auto;

    public Mietvertrag(Reservierung reservierung, int km_stand_uebergabe, int km_stand_rueckgabe, Auto auto) {
        this.reservierung = reservierung;
        this.km_stand_uebergabe = km_stand_uebergabe;
        this.km_stand_rueckgabe = km_stand_rueckgabe;
        this.auto = auto;
    }

    public Reservierung getReservierung() {
        return reservierung;
    }

    public void setReservierung(Reservierung reservierung) {
        this.reservierung = reservierung;
    }

    public int getKm_stand_uebergabe() {
        return km_stand_uebergabe;
    }

    public void setKm_stand_uebergabe(int km_stand_uebergabe) {
        this.km_stand_uebergabe = km_stand_uebergabe;
    }

    public int getKm_stand_rueckgabe() {
        return km_stand_rueckgabe;
    }

    public void setKm_stand_rueckgabe(int km_stand_rueckgabe) {
        this.km_stand_rueckgabe = km_stand_rueckgabe;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
}
