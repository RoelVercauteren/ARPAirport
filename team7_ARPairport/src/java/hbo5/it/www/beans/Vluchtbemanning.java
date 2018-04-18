/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

/**
 *
 * @author roel_
 */
public class Vluchtbemanning {
    private int id;
    private int luchtvaartmaatschappij_id;
    private Luchtvaartmaatschappij luchtvaartmaatschappij;
    private int persoon_id;
    private Persoon persoon;
    private int functie_id;
    private Functie functie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLuchtvaartmaatschappij_id() {
        return luchtvaartmaatschappij_id;
    }

    public void setLuchtvaartmaatschappij_id(int luchtvaartmaatschappij_id) {
        this.luchtvaartmaatschappij_id = luchtvaartmaatschappij_id;
    }

    public Luchtvaartmaatschappij getLuchtvaartmaatschappij() {
        return luchtvaartmaatschappij;
    }

    public void setLuchtvaartmaatschappij(Luchtvaartmaatschappij luchtvaartmaatschappij) {
        this.luchtvaartmaatschappij = luchtvaartmaatschappij;
    }

    public int getPersoon_id() {
        return persoon_id;
    }

    public void setPersoon_id(int persoon_id) {
        this.persoon_id = persoon_id;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public int getFunctie_id() {
        return functie_id;
    }

    public void setFunctie_id(int functie_id) {
        this.functie_id = functie_id;
    }

    public Functie getFunctie() {
        return functie;
    }

    public void setFunctie(Functie functie) {
        this.functie = functie;
    }

    public Vluchtbemanning() {
    }

    public Vluchtbemanning(int id, int luchtvaartmaatschappij_id, Luchtvaartmaatschappij luchtvaartmaatschappij, int persoon_id, Persoon persoon, int functie_id, Functie functie) {
        this.id = id;
        this.luchtvaartmaatschappij_id = luchtvaartmaatschappij_id;
        this.luchtvaartmaatschappij = luchtvaartmaatschappij;
        this.persoon_id = persoon_id;
        this.persoon = persoon;
        this.functie_id = functie_id;
        this.functie = functie;
    }
        
}
