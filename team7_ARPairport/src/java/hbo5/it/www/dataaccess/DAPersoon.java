/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Persoon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public Persoon getPersoon() throws SQLException {
        Persoon persoon = null;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM persoon");) {
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
                persoon.setPaswoord(resultSet.getString("pasword"));
                persoon.setSoort(resultSet.getString("soort"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persoon;
    }
    
    public boolean insertPersoon(Persoon newperson){
        boolean resultaat = true;
        
        try
        {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO persoon values (persoon_seq.nextval, ?)");
            statement.setObject(1, newperson);
            statement.executeUpdate();
        } catch(Exception e){
            resultaat=false;
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
                } catch (Exception ex) {}
                stmt = null;
            }
        }
        return user;
    }
}
