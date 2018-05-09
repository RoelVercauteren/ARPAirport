/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Luchtvaartmaatschappij;
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
public class DALuchtvaartmaatschappij {

    private final String url, login, password;

    public DALuchtvaartmaatschappij(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Luchtvaartmaatschappij getLuchthaven() throws SQLException {
        Luchtvaartmaatschappij luchtvaarmaatschappij = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM luchtvaarmaatschappij ");) {
            if (resultSet.next()) {
                luchtvaarmaatschappij = new Luchtvaartmaatschappij();
                luchtvaarmaatschappij.setId(resultSet.getInt("id"));
                luchtvaarmaatschappij.setLuchtvaartnaam(resultSet.getString("luchtvaartnaam"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return luchtvaarmaatschappij;
    }

    public ArrayList<Luchtvaartmaatschappij> getLuchtvaartmaatschappijen() {
        ArrayList luchtvaartmaatschappijen = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from luchtvaartmaatschappij");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Luchtvaartmaatschappij luchtvaartmaatschappij = new Luchtvaartmaatschappij();

                luchtvaartmaatschappij.setId(resultSet.getInt("id"));
                luchtvaartmaatschappij.setLuchtvaartnaam(resultSet.getString("luchtvaartnaam"));

                luchtvaartmaatschappijen.add(luchtvaartmaatschappij);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return luchtvaartmaatschappijen;
    }
}
