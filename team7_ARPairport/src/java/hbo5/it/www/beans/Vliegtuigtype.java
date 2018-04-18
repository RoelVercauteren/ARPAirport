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
public class Vliegtuigtype {
    private int id;
    private String typenaam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypenaam() {
        return typenaam;
    }

    public void setTypenaam(String typenaam) {
        this.typenaam = typenaam;
    }

    public Vliegtuigtype() {
    }

    public Vliegtuigtype(int id, String typenaam) {
        this.id = id;
        this.typenaam = typenaam;
    }
        
}
