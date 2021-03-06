/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Vliegtuigtype;
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
public class DAVliegtuigtype {

    private final String url, login, password;

    public DAVliegtuigtype(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Vliegtuigtype getVliegtuigtype() throws SQLException {
        Vliegtuigtype vliegtuigtype = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM vligtuigtype");) {
            if (resultSet.next()) {
                vliegtuigtype = new Vliegtuigtype();
                vliegtuigtype.setId(resultSet.getInt("id"));
                vliegtuigtype.setTypenaam(resultSet.getString("typenaam"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vliegtuigtype;
    }

    public ArrayList<Vliegtuigtype> getVliegtuigtypes() {
        ArrayList<Vliegtuigtype> vliegtuigtypes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from vliegtuigtype");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Vliegtuigtype vliegtuigtype = new Vliegtuigtype();

                vliegtuigtype.setId(resultSet.getInt("id"));
                vliegtuigtype.setTypenaam(resultSet.getString("typenaam"));

                vliegtuigtypes.add(vliegtuigtype);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vliegtuigtypes;
    }

}
