/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vliegtuigklasse;
import hbo5.it.www.beans.Vlucht;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

/**
 *
 * @author andre
 */
public class DAPassagier {

    private final String url, login, password;

    public DAPassagier(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Passagier getPassagier() throws SQLException {
        Passagier passagier = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM passagier");) {
            if (resultSet.next()) {
                passagier = new Passagier();
                passagier.setId(resultSet.getInt("id"));
                passagier.setIngeschreven(resultSet.getInt("ingeschreven"));
                passagier.setIngecheckt(resultSet.getInt("ingecheckt"));
                passagier.setKlasse_id(resultSet.getInt("klasse_id"));
                passagier.setPlaats(resultSet.getString("plaats"));
                passagier.setVlucht_id(resultSet.getInt("vlucht_id"));
                passagier.setPersoon_id(resultSet.getInt("persoon_id"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passagier;
    }

    public int getGemiddeldeLeeftijdPerBestemming(int bestemmingid) {
        ArrayList<Passagier> passagiers = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from PASSAGIER join VLUCHT on VLUCHT.ID=VLUCHT_ID join PERSOON on PERSOON_ID=PERSOON.ID where VLUCHT.AANKOMSTLUCHTHAVEN_ID=?");) {
            statement.setInt(1, bestemmingid);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Passagier passagier = new Passagier();
                passagier.setId(resultSet.getInt("id"));

                Persoon persoon = new Persoon();
                persoon.setGeboortedatum(resultSet.getDate("geboortedatum"));
                passagier.setPersoon(persoon);

                passagiers.add(passagier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int totaalLeeftijd = 0;
        for (Passagier passagier : passagiers) {
            totaalLeeftijd += Period.between(passagier.getPersoon().getGeboortedatum().toLocalDate(), LocalDate.now()).getYears();
        }
        if (passagiers.size() != 0) {
            return totaalLeeftijd / passagiers.size();
        }
        return -1;

    }

    public ArrayList<Passagier> getPassagiersPerVlucht(int vluchtid) {
        ArrayList<Passagier> passagiers = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from PASSAGIER join VLUCHT on VLUCHT.ID=VLUCHT_ID join VLIEGTUIGKLASSE on KLASSE_ID=VLIEGTUIGKLASSE.ID where VLUCHT_ID=?");) {
            statement.setInt(1, vluchtid);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Passagier passagier = new Passagier();
                passagier.setId(resultSet.getInt("id"));
                passagier.setKlasse_id(resultSet.getInt("klasse_id")); 

                Vliegtuigklasse klasse = new Vliegtuigklasse();
                klasse.setId(resultSet.getInt("klasse_id"));
                klasse.setKlassenaam(resultSet.getString("klassenaam"));

                passagier.setVliegtuigklasse(klasse);

                passagiers.add(passagier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return passagiers;
    }

}
