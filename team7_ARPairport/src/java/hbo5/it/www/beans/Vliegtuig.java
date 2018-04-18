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
public class Vliegtuig {
    private int id;
    private int vliegtuigtype_id;
    private Vliegtuigtype vliegtuigtype;
    private int luchtvaartmaatschappij_id;
    private Luchtvaartmaatschappij luchtvaartmaatschappij;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVliegtuigtype_id() {
        return vliegtuigtype_id;
    }

    public void setVliegtuigtype_id(int vliegtuigtype_id) {
        this.vliegtuigtype_id = vliegtuigtype_id;
    }

    public Vliegtuigtype getVliegtuigtype() {
        return vliegtuigtype;
    }

    public void setVliegtuigtype(Vliegtuigtype vliegtuigtype) {
        this.vliegtuigtype = vliegtuigtype;
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

    public Vliegtuig() {
    }

    public Vliegtuig(int id, int vliegtuigtype_id, Vliegtuigtype vliegtuigtype, int luchtvaartmaatschappij_id, Luchtvaartmaatschappij luchtvaartmaatschappij) {
        this.id = id;
        this.vliegtuigtype_id = vliegtuigtype_id;
        this.vliegtuigtype = vliegtuigtype;
        this.luchtvaartmaatschappij_id = luchtvaartmaatschappij_id;
        this.luchtvaartmaatschappij = luchtvaartmaatschappij;
    }
        
}
