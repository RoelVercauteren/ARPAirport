/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Hangar;
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
public class DAHangar {

    private final String url, login, password;

    public DAHangar(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Hangar getHangar() throws SQLException {
        Hangar hangar = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM hangar");) {
            if (resultSet.next()) {
                hangar = new Hangar();
                hangar.setId(resultSet.getInt("id"));
                hangar.setHangarnaam(resultSet.getString("hangarnaam"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hangar;
    }

    public Hangar getHangar(int id) {
        Hangar hangar = null;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from hangar where id=?");) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                hangar = new Hangar();
                hangar.setId(resultSet.getInt("id"));
                hangar.setHangarnaam(resultSet.getString("hangarnaam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hangar;
    }

    public ArrayList<Hangar> getHangars() {
        ArrayList<Hangar> hangars = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from hangar");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Hangar hangar = new Hangar();

                hangar.setId(resultSet.getInt("id"));
                hangar.setHangarnaam(resultSet.getString("hangarnaam"));

                hangars.add(hangar);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hangars;
    }

    public boolean addHangar(String naam) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO Hangar VALUES (HANGAR_seq.nextval, ?)");) {
            statement.setString(1, naam);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    public boolean updateHangar(int id, String naam) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update HANGAR set hangarnaam=? where id=?");) {
            statement.setString(1, naam);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }       
    
    public boolean deleteHangar(int id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from hangar where id=?");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }
    

}
