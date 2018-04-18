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
public class Luchtvaartmaatschappij {
    private int id;
    private String luchtvaartnaam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLuchtvaartnaam() {
        return luchtvaartnaam;
    }

    public void setLuchtvaartnaam(String luchtvaartnaam) {
        this.luchtvaartnaam = luchtvaartnaam;
    }

    public Luchtvaartmaatschappij() {
    }

    public Luchtvaartmaatschappij(int id, String luchtvaartnaam) {
        this.id = id;
        this.luchtvaartnaam = luchtvaartnaam;
    }
    
    
}
