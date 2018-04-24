/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;


import hbo5.it.www.beans.Vluchtbemanning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class DAVluchtbemanning {
        private final String url, login, password;

    public DAVluchtbemanning (String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Vluchtbemanning getVluchtbemanning () throws SQLException {
        Vluchtbemanning vluchtbemanning = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM vluchtbemanning");) {
            if (resultSet.next()) {
                vluchtbemanning = new Vluchtbemanning();
                vluchtbemanning.setId(resultSet.getInt("id"));
                vluchtbemanning.setTaak(resultSet.getString("taak"));
                vluchtbemanning.setBemanningslid_id(resultSet.getInt("bemanningslid_id"));
                vluchtbemanning.setVlucht_id(resultSet.getInt("vluvht_id"));
                
                
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vluchtbemanning;
    }
}
