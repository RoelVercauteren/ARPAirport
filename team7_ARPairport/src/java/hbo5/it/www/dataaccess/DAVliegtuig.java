/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;


import hbo5.it.www.beans.Vliegtuig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class DAVliegtuig {
    private final String url, login, password;

    public DAVliegtuig(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Vliegtuig getVliegtuig () throws SQLException {
        Vliegtuig vliegtuig = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM vligtuig");) {
            if (resultSet.next()) {
                vliegtuig = new Vliegtuig();
                vliegtuig.setId(resultSet.getInt("id"));
                vliegtuig.setLuchtvaartmaatschappij_id(resultSet.getInt("luchtvaartmaatchappij_id"));
                vliegtuig.setVliegtuigtype_id(resultSet.getInt("vliegtuigtype_id"));
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vliegtuig;
    }

}
