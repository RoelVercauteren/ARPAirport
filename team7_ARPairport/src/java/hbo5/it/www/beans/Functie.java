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
public class Functie {
    private int id;
    private String functienaam;
    private String omschrijving;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFunctienaam() {
        return functienaam;
    }

    public void setFunctienaam(String functienaam) {
        this.functienaam = functienaam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Functie() {
    }

    public Functie(int id, String functienaam, String omschrijving) {
        this.id = id;
        this.functienaam = functienaam;
        this.omschrijving = omschrijving;
    }
    
    
}
