/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vlucht;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.resource.spi.ConnectionManager;

/**
 *
 * @author andre
 */
public class DAPersoon {

    private final String url, login, password;

    public DAPersoon(String url, String login, String password, String driver)
            throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Persoon getPersoon(String username) throws SQLException {
        Persoon persoon = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM persoon WHERE Login = '" + username + "'");) {
            if (resultSet.next()) {
                persoon = new Persoon();
                persoon.setId(resultSet.getInt("id"));
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

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persoon;
    }

    public ArrayList<Persoon> getPersonen() {
        ArrayList<Persoon> personen = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from persoon");) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Persoon persoon = new Persoon();

                persoon.setId(resultSet.getInt("id"));
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

                personen.add(persoon);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return personen;
    }

    public boolean insertPersoon(Persoon newperson) {
        boolean resultaat = true;

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            String insertTableSQL = "INSERT INTO PERSOON"
                    + "(ID, Voornaam, Familienaam, Straat, Huisnr, Postcode, Woonplaats, Land, Geboortedatum, Login, Paswoord, Soort) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(insertTableSQL);
            Statement searchstatement = connection.createStatement();
            ResultSet result = searchstatement.executeQuery("SELECT COUNT (*) AS total FROM PERSOON");
            while (result.next()) {
                int aantal = result.getInt("total");
                statement.setInt(1, aantal + 1);
            }
            statement.setString(2, newperson.getVoornaam());
            statement.setString(3, newperson.getFamilienaam());
            statement.setString(4, newperson.getStraat());
            statement.setString(5, newperson.getHuisnr());
            statement.setString(6, newperson.getPostcode());
            statement.setString(7, newperson.getWoonplaats());
            statement.setString(8, newperson.getLand());
            statement.setDate(9, newperson.getGeboortedatum());
            statement.setString(10, newperson.getLogin());
            statement.setString(11, newperson.getPaswoord());
            statement.setString(12, "P");
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public Persoon login(Persoon user) {
        Statement stmt = null;
        Connection currentCon = null;
        ResultSet rs = null;
        String username = user.getLogin();
        String password = user.getPaswoord();

        String searchQuery = "SELECT * FROM PERSOON WHERE login='" + username + "' AND Paswoord='" + password + "'";

        try {
            Connection connection = DriverManager.getConnection(this.url, this.login, this.password);
            stmt = connection.createStatement();
            rs = stmt.executeQuery(searchQuery);

            if (!rs.next()) {
                user.setValid(false);
            } else {
                user.setValid(true);
            }
        } catch (Exception ex) {
            System.out.println("Login failed: An Exception has occured!" + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception ex) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception ex) {
                }
                stmt = null;
            }
        }
        return user;
    }
     public ArrayList<Vlucht> getVluchtenByPersoon(String persoonId) {
        ArrayList<Vlucht> vluchten = new ArrayList<>();
       
      
        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement(
                        "select * from  persoon join passagier "
                                + "on PERSOON.ID=PASSAGIER.PERSOON_ID join vlucht "
                                + "on VLUCHT.ID=PASSAGIER.VLUCHT_ID join vliegtuig "
                                +" on VLIEGTUIG_ID=VLIEGTUIG.ID join LUCHTVAARTMAATSCHAPPIJ "
                                + "on VLIEGTUIG.LUCHTVAARTMAATSCHAPPIJ_ID=LUCHTVAARTMAATSCHAPPIJ.ID join LUCHTHAVEN "
                                + "on AANKOMSTLUCHTHAVEN_ID=LUCHTHAVEN.ID join LUCHTHAVEN "
                                +" on VERTREKLUCHTHAVEN_ID=LUCHTHAVEN.ID where PERSOON.ID=?"
                );) {
            statement.setString(1, persoonId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())   {
                Vlucht vlucht=new Vlucht();
                vlucht.setId(resultSet.getInt("id"));
                vlucht.setCode(resultSet.getString("code"));
                vlucht.setVertrektijd(resultSet.getDate("vertrektijd"));
                
                vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(resultSet.getInt("vliegtuig_id"));
                vliegtuig.setLuchtvaartmaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));
                Luchtvaartmaatschappij luchtvmp = new Luchtvaartmaatschappij();
                luchtvmp.setId(resultSet.getInt("luchtvaartmaatschappij_id"));
                luchtvmp.setLuchtvaartnaam(resultSet.getString("luchtvaartnaam"));
                vliegtuig.setLuchtvaartmaatschappij(luchtvmp);
                vliegtuig.setVliegtuigtype_id(resultSet.getInt("vliegtuigtype_id"));
                vlucht.setVliegtuig(vliegtuig);
                
                vlucht.setVertrekluchthaven_id(resultSet.getInt("vertrekluchthaven_id"));
                Luchthaven vertrekhaven = new Luchthaven();
                vertrekhaven.setId(resultSet.getInt(15));
                vertrekhaven.setLuchthavennaam(resultSet.getString(16));
                vertrekhaven.setStad(resultSet.getString(17));
                vertrekhaven.setLand_id(resultSet.getInt(18));
                vlucht.setVertrekluchthaven(vertrekhaven);
                
                vlucht.setAankomstluchthaven_id(resultSet.getInt("aankomstluchthaven_id"));
                Luchthaven aankomsthaven = new Luchthaven();
                aankomsthaven.setId(resultSet.getInt(11));
                aankomsthaven.setLuchthavennaam(resultSet.getString(12));
                aankomsthaven.setStad(resultSet.getString(13));
                aankomsthaven.setLand_id(resultSet.getInt(14));
                vlucht.setAankomstluchthaven(aankomsthaven);
                
                vlucht.setAankomsttijd(resultSet.getDate("aankomsttijd"));
                vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                
                vluchten.add(vlucht);
            }     
                    

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vluchten;
    }
}
