/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Land;
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
public class DALand {

    private final String url, login, password;

    public DALand(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Land getLand() throws SQLException {
        Land land = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM land ");) {
            if (resultSet.next()) {
                land = new Land();
                land.setId(resultSet.getInt("id"));
                land.setLandnaam(resultSet.getString("landnaam"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return land;
    }

    public ArrayList<Land> getLanden() {
        ArrayList<Land> landen = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from land");) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Land land = new Land();

                land.setId(resultSet.getInt("id"));
                land.setLandnaam(resultSet.getString("landnaam"));

                landen.add(land);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return landen;
    }
}
