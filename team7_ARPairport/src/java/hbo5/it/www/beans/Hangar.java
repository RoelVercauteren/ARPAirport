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
public class Hangar {
    private int id;
    private String hangarnaam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHangarnaam() {
        return hangarnaam;
    }

    public void setHangarnaam(String hangarnaam) {
        this.hangarnaam = hangarnaam;
    }

    public Hangar() {
    }

    public Hangar(int id, String hangarnaam) {
        this.id = id;
        this.hangarnaam = hangarnaam;
    }
        
}
