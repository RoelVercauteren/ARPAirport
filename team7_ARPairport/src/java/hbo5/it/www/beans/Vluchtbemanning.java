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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the taak
     */
    public String getTaak() {
        return taak;
    }

    /**
     * @param taak the taak to set
     */
    public void setTaak(String taak) {
        this.taak = taak;
    }

    /**
     * @return the bemanningsl_id
     */
    public int getBemanningslid_id() {
        return bemanningslid_id;
    }

    /**
     * @param bemanningsl_id the bemanningsl_id to set
     */
    public void setBemanningslid_id(int bemanningslid_id) {
        this.bemanningslid_id = bemanningslid_id;
    }

    /**
     * @return the vlucht_id
     */
    public int getVlucht_id() {
        return vlucht_id;
    }

    /**
     * @param vlucht_id the vlucht_id to set
     */
    public void setVlucht_id(int vlucht_id) {
        this.vlucht_id = vlucht_id;
    }

    /**
     * @return the vlucht
     */
    public Vlucht getVlucht() {
        return vlucht;
    }

    /**
     * @param vlucht the vlucht to set
     */
    public void setVlucht(Vlucht vlucht) {
        this.vlucht = vlucht;
    }

    /**
     * @return the bemanningslid
     */
    public Bemanningslid getBemanningslid() {
        return bemanningslid;
    }

    /**
     * @param bemanningslid the bemanningslid to set
     */
    public void setBemanningslid(Bemanningslid bemanningslid) {
        this.bemanningslid = bemanningslid;
    }

    public Vluchtbemanning() {
    }

    public Vluchtbemanning(int id, String taak, int bemanningsl_id, int vlucht_id, Vlucht vlucht, Bemanningslid bemanningslid) {
        this.id = id;
        this.taak = taak;
        this.bemanningslid_id = bemanningslid_id;
        this.vlucht_id = vlucht_id;
        this.vlucht = vlucht;
        this.bemanningslid = bemanningslid;
    }
    private int id;
    private String taak;
    private int bemanningslid_id;
    private int vlucht_id;
    private Vlucht vlucht;
    private Bemanningslid bemanningslid;

}
