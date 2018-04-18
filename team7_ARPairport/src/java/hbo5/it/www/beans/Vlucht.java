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
public class Vlucht {
    private int id;
    private String code;
    private LocalDate vertrektijd;
    private LocalDate aankomsttijd;
    private int vliegtuig_id;
    private Vliegtuig vliegtuig;
    private int vertrekluchthaven_id;
    private Luchthaven vertrekluchthaven;
    private int aankomstluchthaven_id;
    private Luchthaven aankomstluchthaven;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getVertrektijd() {
        return vertrektijd;
    }

    public void setVertrektijd(LocalDate vertrektijd) {
        this.vertrektijd = vertrektijd;
    }

    public LocalDate getAankomsttijd() {
        return aankomsttijd;
    }

    public void setAankomsttijd(LocalDate aankomsttijd) {
        this.aankomsttijd = aankomsttijd;
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

    public int getVertrekluchthaven_id() {
        return vertrekluchthaven_id;
    }

    public void setVertrekluchthaven_id(int vertrekluchthaven_id) {
        this.vertrekluchthaven_id = vertrekluchthaven_id;
    }

    public Luchthaven getVertrekluchthaven() {
        return vertrekluchthaven;
    }

    public void setVertrekluchthaven(Luchthaven vertrekluchthaven) {
        this.vertrekluchthaven = vertrekluchthaven;
    }

    public int getAankomstluchthaven_id() {
        return aankomstluchthaven_id;
    }

    public void setAankomstluchthaven_id(int aankomstluchthaven_id) {
        this.aankomstluchthaven_id = aankomstluchthaven_id;
    }

    public Luchthaven getAankomstluchthaven() {
        return aankomstluchthaven;
    }

    public void setAankomstluchthaven(Luchthaven aankomstluchthaven) {
        this.aankomstluchthaven = aankomstluchthaven;
    }

    public Vlucht() {
    }

    public Vlucht(int id, String code, LocalDate vertrektijd, LocalDate aankomsttijd, int vliegtuig_id, Vliegtuig vliegtuig, int vertrekluchthaven_id, Luchthaven vertrekluchthaven, int aankomstluchthaven_id, Luchthaven aankomstluchthaven) {
        this.id = id;
        this.code = code;
        this.vertrektijd = vertrektijd;
        this.aankomsttijd = aankomsttijd;
        this.vliegtuig_id = vliegtuig_id;
        this.vliegtuig = vliegtuig;
        this.vertrekluchthaven_id = vertrekluchthaven_id;
        this.vertrekluchthaven = vertrekluchthaven;
        this.aankomstluchthaven_id = aankomstluchthaven_id;
        this.aankomstluchthaven = aankomstluchthaven;
    }
        
}
