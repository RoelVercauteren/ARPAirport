/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Stockage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class DAStockage {

    private final String url, login, password;

    public DAStockage(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Stockage getStockage() throws SQLException {
        Stockage stockage = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM stockage where id = 1");) {
            if (resultSet.next()) {
                stockage = new Stockage();
                stockage.setId(resultSet.getInt("id"));
                stockage.setReden(resultSet.getString("reden"));
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockage;
    }
}
