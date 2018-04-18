/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

import java.time.LocalDate;

/**
 *
 * @author roel_
 */
public class Stockage {
    private int id;
    private String reden;
    private LocalDate vandatum;
    private LocalDate totdatum;
    private int vliegtuig_id;
    private Vliegtuig vliegtuig;
    private int hangar_id;
    private Hangar hangar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReden() {
        return reden;
    }

    public void setReden(String reden) {
        this.reden = reden;
    }

    public LocalDate getVandatum() {
        return vandatum;
    }

    public void setVandatum(LocalDate vandatum) {
        this.vandatum = vandatum;
    }

    public LocalDate getTotdatum() {
        return totdatum;
    }

    public void setTotdatum(LocalDate totdatum) {
        this.totdatum = totdatum;
    }

    public int getVliegtuig_id() {
        return vliegtuig_id;
    }

    public void setVliegtuig_id(int vliegtuig_id) {
        this.vliegtuig_id = vliegtuig_id;
    }

    public Vliegtuig getVliegtuig() {
        return vliegtuig;
    }

    public void setVliegtuig(Vliegtuig vliegtuig) {
        this.vliegtuig = vliegtuig;
    }

    public int getHangar_id() {
        return hangar_id;
    }

    public void setHangar_id(int hangar_id) {
        this.hangar_id = hangar_id;
    }

    public Hangar getHangar() {
        return hangar;
    }

    public void setHangar(Hangar hangar) {
        this.hangar = hangar;
    }

    public Stockage() {
    }

    public Stockage(int id, String reden, LocalDate vandatum, LocalDate totdatum, int vliegtuig_id, Vliegtuig vliegtuig, int hangar_id, Hangar hangar) {
        this.id = id;
        this.reden = reden;
        this.vandatum = vandatum;
        this.totdatum = totdatum;
        this.vliegtuig_id = vliegtuig_id;
        this.vliegtuig = vliegtuig;
        this.hangar_id = hangar_id;
        this.hangar = hangar;
    }
        
}
