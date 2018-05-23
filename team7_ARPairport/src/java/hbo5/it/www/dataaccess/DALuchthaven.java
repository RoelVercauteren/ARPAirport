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

    public Luchthaven getLuchthaven(int id) {
        Luchthaven luchthaven = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from luchthaven where id=?");) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

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
                PreparedStatement statement = connection.prepareStatement("select * from LUCHTHAVEN join LAND on LAND.ID=LUCHTHAVEN.LAND_ID");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Luchthaven luchthaven = new Luchthaven();

                luchthaven.setId(resultSet.getInt("id"));
                luchthaven.setLuchthavennaam(resultSet.getString("luchthavennaam"));
                luchthaven.setStad(resultSet.getString("stad"));
                luchthaven.setLand_id(resultSet.getInt("land_id"));

                Land land = new Land();
                land.setId(resultSet.getInt("land_id"));
                land.setLandnaam(resultSet.getString("landnaam"));
                luchthaven.setLand(land);

                luchthavens.add(luchthaven);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return luchthavens;
    }

    public boolean addLuchthaven(String naam, String stad, int land_id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO LUCHTHAVEN VALUES (LUCHTHAVEN_seq.nextval, ?, ?, ?)");) {
            statement.setString(1, naam);
            statement.setString(2, stad);
            statement.setInt(3, land_id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public boolean deleteLuchthaven(int id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from luchthaven where id=?");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    public boolean updateLuchthaven(int id, String naam, String stad, int landid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update luchthaven set luchthavennaam=?, stad=?,land_id=? where id=?");) {
            statement.setString(1, naam);
            statement.setString(2, stad);
            statement.setInt(3, landid);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

}
