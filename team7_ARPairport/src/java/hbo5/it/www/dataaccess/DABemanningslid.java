/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Persoon;
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
public class DABemanningslid {

    private final String url, login, password;

    public DABemanningslid(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Bemanningslid getBemanningslid() throws SQLException {
        Bemanningslid bemanningslid = null;
        try (Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM bemanningslid ");) {
            if (resultSet.next()) {
                bemanningslid = new Bemanningslid();
                bemanningslid.setId(resultSet.getInt("id"));
                bemanningslid.setLuchtvaartmaatschappij_id(resultSet.getInt("luchtvaartmaatchappij_id"));
                bemanningslid.setPersoon_id(resultSet.getInt("persoon_id"));
                bemanningslid.setFunctie_id(resultSet.getInt("fucntie_id"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bemanningslid;
    }

    public Bemanningslid getBemanningslid(int id) {
        Bemanningslid bemanningslid = null;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from bemanningslid join LUCHTVAARTMAATSCHAPPIJ on LUCHTVAARTMAATSCHAPPIJ_ID=LUCHTVAARTMAATSCHAPPIJ.ID join PERSOON on PERSOON_ID=PERSOON.ID join FUNCTIE on FUNCTIE_ID=FUNCTIE.ID WHERE BEMANNINGSLID.ID=?");) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                bemanningslid = new Bemanningslid();

                bemanningslid.setId(resultSet.getInt("id"));

                bemanningslid.setLuchtvaartmaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));

                Luchtvaartmaatschappij luchtvaartmaatschappij = new Luchtvaartmaatschappij();
                luchtvaartmaatschappij.setId(resultSet.getInt("luchtvaartmaatschappij_id"));
                luchtvaartmaatschappij.setLuchtvaartnaam(resultSet.getString("luchtvaartnaam"));
                bemanningslid.setLuchtvaartmaatschappij(luchtvaartmaatschappij);

                bemanningslid.setFunctie_id(resultSet.getInt("functie_id"));

                Functie functie = new Functie();
                functie.setId(resultSet.getInt("functie_id"));
                functie.setFunctienaam(resultSet.getString("functienaam"));
                functie.setOmschrijving(resultSet.getString("omschrijving"));
                bemanningslid.setFunctie(functie);

                bemanningslid.setPersoon_id(resultSet.getInt("persoon_id"));

                Persoon persoon = new Persoon();
                persoon.setId(resultSet.getInt("persoon_id"));
                persoon.setVoornaam(resultSet.getString("voornaam"));
                persoon.setFamilienaam(resultSet.getString("familienaam"));
                persoon.setStraat(resultSet.getString("straat"));
                persoon.setHuisnr(resultSet.getString("huisnr"));
                persoon.setPostcode(resultSet.getString("postcode"));
                persoon.setWoonplaats(resultSet.getString("woonplaats"));
                persoon.setLand(resultSet.getString("land"));
                persoon.setGeboortedatum(resultSet.getDate("geboortedatum"));
                persoon.setLogin(resultSet.getString("login"));
                persoon.setPaswoord(resultSet.getString("paswoord"));
                persoon.setSoort(resultSet.getString("soort"));
                bemanningslid.setPersoon(persoon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bemanningslid;
    }

    public ArrayList<Bemanningslid> getBemanningsleden() {
        ArrayList<Bemanningslid> bemanningsleden = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from bemanningslid join LUCHTVAARTMAATSCHAPPIJ on LUCHTVAARTMAATSCHAPPIJ_ID=LUCHTVAARTMAATSCHAPPIJ.ID join PERSOON on PERSOON_ID=PERSOON.ID join FUNCTIE on FUNCTIE_ID=FUNCTIE.ID");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Bemanningslid bemanningslid = new Bemanningslid();

                bemanningslid.setId(resultSet.getInt("id"));

                bemanningslid.setLuchtvaartmaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));

                Luchtvaartmaatschappij luchtvaartmaatschappij = new Luchtvaartmaatschappij();
                luchtvaartmaatschappij.setId(resultSet.getInt("luchtvaartmaatschappij_id"));
                luchtvaartmaatschappij.setLuchtvaartnaam(resultSet.getString("luchtvaartnaam"));
                bemanningslid.setLuchtvaartmaatschappij(luchtvaartmaatschappij);

                bemanningslid.setFunctie_id(resultSet.getInt("functie_id"));

                Functie functie = new Functie();
                functie.setId(resultSet.getInt("functie_id"));
                functie.setFunctienaam(resultSet.getString("functienaam"));
                functie.setOmschrijving(resultSet.getString("omschrijving"));
                bemanningslid.setFunctie(functie);

                bemanningslid.setPersoon_id(resultSet.getInt("persoon_id"));

                Persoon persoon = new Persoon();
                persoon.setId(resultSet.getInt("persoon_id"));
                persoon.setVoornaam(resultSet.getString("voornaam"));
                persoon.setFamilienaam(resultSet.getString("familienaam"));
                persoon.setStraat(resultSet.getString("straat"));
                persoon.setHuisnr(resultSet.getString("huisnr"));
                persoon.setPostcode(resultSet.getString("postcode"));
                persoon.setWoonplaats(resultSet.getString("woonplaats"));
                persoon.setLand(resultSet.getString("land"));
                persoon.setGeboortedatum(resultSet.getDate("geboortedatum"));
                persoon.setLogin(resultSet.getString("login"));
                persoon.setPaswoord(resultSet.getString("paswoord"));
                persoon.setSoort(resultSet.getString("soort"));
                bemanningslid.setPersoon(persoon);

                bemanningsleden.add(bemanningslid);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bemanningsleden;
    }

    public boolean addBemanningslid(int functieid, int persoonid, int luchtvaartmaatschappijid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO bemanningslid VALUES (bemanningslid_seq.nextval, ?, ?, ?)");) {

            statement.setInt(1, luchtvaartmaatschappijid);
            statement.setInt(2, persoonid);
            statement.setInt(3, functieid);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    public boolean updateBemanningslid(int id, int functieid, int persoonid, int luchtvaartmaatschappijid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update bemanningslid set functie_id=?, persoon_id=?, luchtvaartmaatschappij_id=? where id=?");) {
            statement.setInt(1, functieid);
            statement.setInt(2, persoonid);
            statement.setInt(3, luchtvaartmaatschappijid);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    public boolean deleteBemanningslid(int id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from bemanningslid where id=?");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

}
