/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Functie;
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
public class DAFunctie {

    private final String url, login, password;

    public DAFunctie(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Functie getFunctie() throws SQLException {
        Functie functie = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM functie");) {
            if (resultSet.next()) {
                functie = new Functie();
                functie.setId(resultSet.getInt("id"));
                functie.setFunctienaam(resultSet.getString("functienaam"));
                functie.setOmschrijving(resultSet.getString("omschrijving"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return functie;
    }

    public ArrayList<Functie> getFuncties() {

        ArrayList<Functie> functies = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from functie");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Functie functie = new Functie();

                functie.setId(resultSet.getInt("id"));
                functie.setFunctienaam(resultSet.getString("functienaam"));
                functie.setOmschrijving(resultSet.getString("omschrijving"));

                functies.add(functie);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return functies;
    }
}
