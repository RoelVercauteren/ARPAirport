/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Vliegtuigklasse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class DAVliegtuigklasse {

    private final String url, login, password;

    public DAVliegtuigklasse(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Vliegtuigklasse getVliegtuigklasse() throws SQLException {
        Vliegtuigklasse vliegtuigklasse = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM vligtuigklasse");) {
            if (resultSet.next()) {
                vliegtuigklasse = new Vliegtuigklasse();
                vliegtuigklasse.setId(resultSet.getInt("id"));
                vliegtuigklasse.setKlassenaam(resultSet.getString("klassenaam"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vliegtuigklasse;
    }

    public ArrayList<Vliegtuigklasse> getVliegtuigKlassen() {
        ArrayList<Vliegtuigklasse> vliegtuigklassen = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from VLIEGTUIGKLASSE");) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vliegtuigklasse klasse = new Vliegtuigklasse();
                klasse.setId(resultSet.getInt("id"));
                klasse.setKlassenaam(resultSet.getString("klassenaam"));

                vliegtuigklassen.add(klasse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vliegtuigklassen;
    }

}
