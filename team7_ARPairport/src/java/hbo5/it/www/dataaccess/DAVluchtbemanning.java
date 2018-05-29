/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.Vluchtbemanning;
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
public class DAVluchtbemanning {

    private final String url, login, password;

    private DABemanningslid dabemanningslid = null;
    private DAVlucht davlucht = null;

    public DAVluchtbemanning(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;

        dabemanningslid = new DABemanningslid(url, login, password, driver);
        davlucht = new DAVlucht(url, login, password, driver);
    }

    public Vluchtbemanning getVluchtbemanning() throws SQLException {
        Vluchtbemanning vluchtbemanning = null;
        try (Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM vluchtbemanning");) {
            if (resultSet.next()) {
                vluchtbemanning = new Vluchtbemanning();
                vluchtbemanning.setId(resultSet.getInt("id"));
                vluchtbemanning.setTaak(resultSet.getString("taak"));
                vluchtbemanning.setBemanningslid_id(resultSet.getInt("bemanningslid_id"));
                vluchtbemanning.setVlucht_id(resultSet.getInt("vlucht_id"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vluchtbemanning;
    }

    public Vluchtbemanning getVluchtbemanning(int id) {

        Vluchtbemanning vluchtbemanning = null;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from vluchtbemanning join BEMANNINGSLID on BEMANNINGSLID_ID=BEMANNINGSLID.ID join VLUCHT on VLUCHT_ID=VLUCHT.ID where VLUCHTBEMANNING.ID=?");) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                vluchtbemanning = new Vluchtbemanning();

                vluchtbemanning.setId(resultSet.getInt("id"));
                vluchtbemanning.setTaak(resultSet.getString("taak"));

                vluchtbemanning.setBemanningslid_id(resultSet.getInt("bemanningslid_id"));
                vluchtbemanning.setBemanningslid(dabemanningslid.getBemanningslid(vluchtbemanning.getBemanningslid_id()));

                vluchtbemanning.setVlucht_id(resultSet.getInt("vlucht_id"));

                Vlucht vlucht = davlucht.getVlucht(vluchtbemanning.getVlucht_id());
                vluchtbemanning.setVlucht(vlucht);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vluchtbemanning;
    }

    public ArrayList<Vluchtbemanning> getVluchtbemanningen() {
        ArrayList<Vluchtbemanning> vluchtbemanningen = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from VLUCHTBEMANNING join BEMANNINGSLID on BEMANNINGSLID_ID=BEMANNINGSLID.ID join VLUCHT on VLUCHT_ID=VLUCHT.ID");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Vluchtbemanning vluchtbemanning = new Vluchtbemanning();

                vluchtbemanning.setId(resultSet.getInt("id"));
                vluchtbemanning.setTaak(resultSet.getString("taak"));

                vluchtbemanning.setBemanningslid_id(resultSet.getInt("bemanningslid_id"));
                vluchtbemanning.setBemanningslid(dabemanningslid.getBemanningslid(vluchtbemanning.getBemanningslid_id()));

                vluchtbemanning.setVlucht_id(resultSet.getInt("vlucht_id"));

                Vlucht vlucht = davlucht.getVlucht(vluchtbemanning.getVlucht_id());
                vluchtbemanning.setVlucht(vlucht);

                vluchtbemanningen.add(vluchtbemanning);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vluchtbemanningen;
    }

    public boolean addVluchtbemanning(String taak, int vluchtid, int bemanningslidid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO vluchtbemanning VALUES (bemanningslid_seq.nextval, ?, ?, ?)");) {

            statement.setString(1, taak);
            statement.setInt(2, bemanningslidid);
            statement.setInt(3, vluchtid);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    public boolean updateVluchtbemanning(int id, String taak, int vluchtid, int bemanningslidid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update vluchtbemanning set taak=?, vlucht_id=?, bemanningslid_id=? where id=?");) {
            statement.setString(1, taak);
            statement.setInt(2, vluchtid);
            statement.setInt(3, bemanningslidid);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    public boolean deleteVluchtbemanning(int id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from vluchtbemanning where id=?");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

}
