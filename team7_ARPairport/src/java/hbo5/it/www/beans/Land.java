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
public class Land {
    private int id;
    private String landnaam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLandnaam() {
        return landnaam;
    }

    public void setLandnaam(String landnaam) {
        this.landnaam = landnaam;
    }

    public Land() {
    }

    public Land(int id, String landnaam) {
        this.id = id;
        this.landnaam = landnaam;
    }
        
}
