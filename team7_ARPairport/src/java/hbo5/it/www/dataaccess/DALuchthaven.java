/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
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
public class DALuchthaven {

    private final String url, login, password;

    public DALuchthaven(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Luchthaven getLuchthaven() throws SQLException {
        Luchthaven luchthaven = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM luchthaven ");) {
            if (resultSet.next()) {
                luchthaven = new Luchthaven();
                luchthaven.setId(resultSet.getInt("id"));
                luchthaven.setLuchthavennaam(resultSet.getString("luchthavennaam"));
                luchthaven.setStad(resultSet.getString("stad"));
                luchthaven.setLand_id(resultSet.getInt("land_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return luchthaven;
    }

    public ArrayList<Luchthaven> getLuchthavens() {
        ArrayList<Luchthaven> luchthavens = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from luchthaven");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Luchthaven luchthaven = new Luchthaven();

                luchthaven.setId(resultSet.getInt("id"));
                luchthaven.setLuchthavennaam(resultSet.getString("luchthavennaam"));
                luchthaven.setStad(resultSet.getString("stad"));
                luchthaven.setLand_id(resultSet.getInt("land_id"));

                luchthavens.add(luchthaven);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return luchthavens;
    }

}
