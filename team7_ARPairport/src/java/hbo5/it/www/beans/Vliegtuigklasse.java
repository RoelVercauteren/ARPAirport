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
public class Vliegtuigklasse {
    private int id;
    private String klassenaam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKlassenaam() {
        return klassenaam;
    }

    public void setKlassenaam(String klassenaam) {
        this.klassenaam = klassenaam;
    }

    public Vliegtuigklasse() {
    }

    public Vliegtuigklasse(int id, String klassenaam) {
        this.id = id;
        this.klassenaam = klassenaam;
    }
        
}
