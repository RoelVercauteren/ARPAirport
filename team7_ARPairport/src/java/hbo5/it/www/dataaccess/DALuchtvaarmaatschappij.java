/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Luchtvaartmaatschappij;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class DALuchtvaarmaatschappij {
    private final String url, login, password;
     public DALuchtvaarmaatschappij(String url, String login, String password, String driver)
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
}
