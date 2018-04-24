/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Passagier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class DAPassagier {
        private final String url, login, password;
     public DAPassagier(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Passagier getPassagier() throws SQLException {
        Passagier passagier = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM passagier where id = 1");) {
            if (resultSet.next()) {
                passagier = new Passagier();
                passagier.setId(resultSet.getInt("id"));
                passagier.setIngeschreven(resultSet.getInt("ingeschreven"));
                passagier.setIngecheckt(resultSet.getInt("ingecheckt"));
                passagier.setKlasse_id(resultSet.getInt("klasse_id"));
                passagier.setPlaats(resultSet.getString("plaats"));
                passagier.setVlucht_id(resultSet.getInt("vlucht_id"));
                passagier.setPersoon_id(resultSet.getInt("persoon_id"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passagier;
    }
}
