/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

import java.util.Comparator;

/**
 *
 * @author roel_
 */

public class VluchtComparator implements Comparator<Vlucht> {
    @Override
    public int compare(Vlucht v1, Vlucht v2) {
        return v1.getVertrektijd().compareTo(v2.getVertrektijd());
    }
}
