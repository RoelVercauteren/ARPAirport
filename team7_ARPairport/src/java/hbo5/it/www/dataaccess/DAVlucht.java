/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;


import hbo5.it.www.beans.Vlucht;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class DAVlucht {
        private final String url, login, password;

    public DAVlucht(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Vlucht getVlucht () throws SQLException {
        Vlucht vlucht = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM vlucht");) {
            if (resultSet.next()) {
                vlucht = new Vlucht();
                vlucht.setId(resultSet.getInt("id"));
                vlucht.setCode(resultSet.getString("code"));
                vlucht.setVertrektijd(resultSet.getDate("vertrektijd"));
                vlucht.setAankomsttijd(resultSet.getDate("aankomsttijd"));
                vlucht.setVliegtuig_id(resultSet.getInt("vligtig_id"));
                vlucht.setVertrekluchthaven_id(resultSet.getInt("vertrekluchthaven_id"));
                vlucht.setAankomstluchthaven_id(resultSet.getInt("aankomstluchthaven_id"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vlucht;
    }
}
