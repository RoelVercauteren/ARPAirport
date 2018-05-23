/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Vliegtuig;
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
public class DAVliegtuig {

    private final String url, login, password;

    public DAVliegtuig(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Vliegtuig getVliegtuig() throws SQLException {
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

    public Vliegtuig getVliegtuig(int id) {
        Vliegtuig vliegtuig = null;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from vliegtuig join VLIEGTUIGTYPE on VLIEGTUIGTYPE_ID=VLIEGTUIGTYPE.ID join LUCHTVAARTMAATSCHAPPIJ on LUCHTVAARTMAATSCHAPPIJ_ID=LUCHTVAARTMAATSCHAPPIJ.ID where vliegtuig.id=?");) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                vliegtuig = new Vliegtuig();

                vliegtuig.setId(resultSet.getInt("id"));
                vliegtuig.setLuchtvaartmaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));

                Luchtvaartmaatschappij luchtvaartmaatschappij = new Luchtvaartmaatschappij();
                luchtvaartmaatschappij.setId(resultSet.getInt("luchtvaartmaatschappij_id"));
                luchtvaartmaatschappij.setLuchtvaartnaam(resultSet.getString("luchtvaartnaam"));
                vliegtuig.setLuchtvaartmaatschappij(luchtvaartmaatschappij);

                vliegtuig.setVliegtuigtype_id(resultSet.getInt("vliegtuigtype_id"));

                Vliegtuigtype vliegtuigtype = new Vliegtuigtype();
                vliegtuigtype.setId(resultSet.getInt("vliegtuigtype_id"));
                vliegtuigtype.setTypenaam(resultSet.getString("typenaam"));
                vliegtuig.setVliegtuigtype(vliegtuigtype);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vliegtuig;
    }

    public ArrayList<Vliegtuig> getVliegtuigen() {
        ArrayList<Vliegtuig> vliegtuigen = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from vliegtuig join VLIEGTUIGTYPE on VLIEGTUIGTYPE_ID=VLIEGTUIGTYPE.ID join LUCHTVAARTMAATSCHAPPIJ on LUCHTVAARTMAATSCHAPPIJ_ID=LUCHTVAARTMAATSCHAPPIJ.ID");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Vliegtuig vliegtuig = new Vliegtuig();

                vliegtuig.setId(resultSet.getInt("id"));
                vliegtuig.setLuchtvaartmaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));

                Luchtvaartmaatschappij luchtvaartmaatschappij = new Luchtvaartmaatschappij();
                luchtvaartmaatschappij.setId(resultSet.getInt("luchtvaartmaatschappij_id"));
                luchtvaartmaatschappij.setLuchtvaartnaam(resultSet.getString("luchtvaartnaam"));
                vliegtuig.setLuchtvaartmaatschappij(luchtvaartmaatschappij);

                vliegtuig.setVliegtuigtype_id(resultSet.getInt("vliegtuigtype_id"));

                Vliegtuigtype vliegtuigtype = new Vliegtuigtype();
                vliegtuigtype.setId(resultSet.getInt("vliegtuigtype_id"));
                vliegtuigtype.setTypenaam(resultSet.getString("typenaam"));
                vliegtuig.setVliegtuigtype(vliegtuigtype);

                vliegtuigen.add(vliegtuig);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vliegtuigen;
    }

    public boolean addVliegtuig(int vliegtuigtypeid, int luchtvaartmaatschappijid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO VLIEGTUIG VALUES (LUCHTHAVEN_seq.nextval, ?, ?)");) {
            statement.setInt(1, vliegtuigtypeid);
            statement.setInt(2, luchtvaartmaatschappijid);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    public boolean updateVliegtuig(int id, int vliegtuigtypeid, int luchtvaartmaatschappijid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update vliegtuig set vliegtuigtype_id=?, luchtvaartmaatschappij_id=? where id=?");) {
            statement.setInt(1, vliegtuigtypeid);
            statement.setInt(2, luchtvaartmaatschappijid);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    public boolean deleteVliegtuig(int id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from vliegtuig where id=?");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

}
