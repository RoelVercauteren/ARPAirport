/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Stockage;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vliegtuigtype;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

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
        try (Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM stockage");) {
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

    public Stockage getStockage(int id) {
        Stockage stockage = null;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from stockage join HANGAR on HANGAR_ID=HANGAR.ID join VLIEGTUIG on VLIEGTUIG_ID=VLIEGTUIG.ID join VLIEGTUIGTYPE on VLIEGTUIG.VLIEGTUIGTYPE_ID=VLIEGTUIGTYPE.ID join LUCHTVAARTMAATSCHAPPIJ on LUCHTVAARTMAATSCHAPPIJ.ID=VLIEGTUIG.LUCHTVAARTMAATSCHAPPIJ_ID where STOCKAGE.ID=?");) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                stockage = new Stockage();

                stockage.setId(resultSet.getInt("id"));
                stockage.setReden(resultSet.getString("reden"));

                java.sql.Date vandatum = resultSet.getDate("vandatum");
                LocalDate localvandatum = vandatum.toLocalDate();
                stockage.setVandatum(localvandatum);

                java.sql.Date totdatum = resultSet.getDate("totdatum");
                LocalDate localtotdatum = totdatum.toLocalDate();
                stockage.setTotdatum(localtotdatum);

                stockage.setHangar_id(resultSet.getInt("hangar_id"));

                Hangar hangar = new Hangar();
                hangar.setId(resultSet.getInt("hangar_id"));
                hangar.setHangarnaam(resultSet.getString("hangarnaam"));
                stockage.setHangar(hangar);

                stockage.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));

                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(resultSet.getInt("vliegtuig_id"));
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

                stockage.setVliegtuig(vliegtuig);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stockage;
    }

    public ArrayList<Stockage> getStockages() {
        ArrayList<Stockage> stockages = new ArrayList<Stockage>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from stockage join HANGAR on HANGAR_ID=HANGAR.ID join VLIEGTUIG on VLIEGTUIG_ID=VLIEGTUIG.ID join VLIEGTUIGTYPE on VLIEGTUIG.VLIEGTUIGTYPE_ID=VLIEGTUIGTYPE.ID join LUCHTVAARTMAATSCHAPPIJ on LUCHTVAARTMAATSCHAPPIJ.ID=VLIEGTUIG.LUCHTVAARTMAATSCHAPPIJ_ID");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Stockage stockage = new Stockage();

                stockage.setId(resultSet.getInt("id"));
                stockage.setReden(resultSet.getString("reden"));

                java.sql.Date vandatum = resultSet.getDate("vandatum");
                LocalDate localvandatum = vandatum.toLocalDate();
                stockage.setVandatum(localvandatum);

                java.sql.Date totdatum = resultSet.getDate("totdatum");
                LocalDate localtotdatum = totdatum.toLocalDate();
                stockage.setTotdatum(localtotdatum);

                stockage.setHangar_id(resultSet.getInt("hangar_id"));

                Hangar hangar = new Hangar();
                hangar.setId(resultSet.getInt("hangar_id"));
                hangar.setHangarnaam(resultSet.getString("hangarnaam"));
                stockage.setHangar(hangar);

                stockage.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));

                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(resultSet.getInt("vliegtuig_id"));
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

                stockage.setVliegtuig(vliegtuig);

                stockages.add(stockage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stockages;
    }

    public boolean addStockage(String reden, LocalDate vandatum, LocalDate totdatum, int vliegtuigid, int hangarid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO stockage VALUES (stockage_seq.nextval, ?, ?, ?, ?, ?)");) {
            statement.setString(1, reden);

            statement.setDate(2, Date.valueOf(vandatum));
            statement.setDate(3, Date.valueOf(totdatum));

            statement.setInt(4, vliegtuigid);
            statement.setInt(5, hangarid);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    public boolean updateStockage(int id, String reden, LocalDate vandatum, LocalDate totdatum, int vliegtuigid, int hangarid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update stockage set reden=?, vandatum=?, totdatum=?, vliegtuig_id=?, hangar_id=? where id=?");) {
            statement.setString(1, reden);

            statement.setDate(2, Date.valueOf(vandatum));
            statement.setDate(3, Date.valueOf(totdatum));

            statement.setInt(4, vliegtuigid);
            statement.setInt(5, hangarid);
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    public boolean deleteStockage(int id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from stockage where id=?");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

}
