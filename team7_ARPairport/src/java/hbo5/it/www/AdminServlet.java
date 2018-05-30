/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Stockage;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vliegtuigtype;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.Vluchtbemanning;
import hbo5.it.www.dataaccess.DABemanningslid;
import hbo5.it.www.dataaccess.DAFunctie;
import hbo5.it.www.dataaccess.DAHangar;
import hbo5.it.www.dataaccess.DALand;
import hbo5.it.www.dataaccess.DALuchthaven;
import hbo5.it.www.dataaccess.DALuchtvaartmaatschappij;
import hbo5.it.www.dataaccess.DAPassagier;
import hbo5.it.www.dataaccess.DAPersoon;
import hbo5.it.www.dataaccess.DAStockage;
import hbo5.it.www.dataaccess.DAVliegtuig;
import hbo5.it.www.dataaccess.DAVliegtuigtype;
import hbo5.it.www.dataaccess.DAVlucht;
import hbo5.it.www.dataaccess.DAVluchtbemanning;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.weld.bootstrap.api.Environment;

/**
 *
 * @author roel_
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "C1042431")
    , @WebInitParam(name = "paswoord", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class AdminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private DALuchthaven daluchthaven = null;
    private DALand dalanden = null;
    private DALuchtvaartmaatschappij daluchtvaartmaatschappij = null;
    private DAVliegtuig davliegtuig = null;
    private DAVliegtuigtype davliegtuigtype = null;
    private DAHangar dahangar = null;
    private DABemanningslid dabemanningslid = null;
    private DAFunctie dafunctie = null;
    private DAPersoon dapersoon = null;
    private DAVluchtbemanning davluchtbemanning = null;
    private DAVlucht davlucht = null;
    private DAStockage dastockage = null;
    private DAPassagier dapassagier = null;

    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String login = getInitParameter("login");
            String paswoord = getInitParameter("paswoord");
            String driver = getInitParameter("driver");

            if (daluchthaven == null) {
                daluchthaven = new DALuchthaven(url, login, paswoord, driver);
            }
            if (dalanden == null) {
                dalanden = new DALand(url, login, paswoord, driver);
            }
            if (daluchtvaartmaatschappij == null) {
                daluchtvaartmaatschappij = new DALuchtvaartmaatschappij(url, login, paswoord, driver);
            }
            if (davliegtuig == null) {
                davliegtuig = new DAVliegtuig(url, login, paswoord, driver);
            }
            if (davliegtuigtype == null) {
                davliegtuigtype = new DAVliegtuigtype(url, login, paswoord, driver);
            }
            if (dahangar == null) {
                dahangar = new DAHangar(url, login, paswoord, driver);
            }
            if (dabemanningslid == null) {
                dabemanningslid = new DABemanningslid(url, login, paswoord, driver);
            }
            if (dafunctie == null) {
                dafunctie = new DAFunctie(url, login, paswoord, driver);
            }
            if (dapersoon == null) {
                dapersoon = new DAPersoon(url, login, paswoord, driver);
            }
            if (davluchtbemanning == null) {
                davluchtbemanning = new DAVluchtbemanning(url, login, paswoord, driver);
            }
            if (davlucht == null) {
                davlucht = new DAVlucht(url, login, paswoord, driver);
            }
            if (dastockage == null) {
                dastockage = new DAStockage(url, login, paswoord, driver);
            }
            if (dapassagier == null) {
                dapassagier = new DAPassagier(url, login, paswoord, driver);
            }

        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd = null;

        if (request.getParameter("knopLuchthaven") != null) {

            ArrayList<Luchthaven> luchthavens = daluchthaven.getLuchthavens();

            rd = request.getRequestDispatcher("Admin/luchthavens.jsp");
            request.setAttribute("luchthavens", luchthavens);

        } else if (request.getParameter("knopLuchtvaartmaatschappijen") != null) {

            ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
            request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

            rd = request.getRequestDispatcher("Admin/luchtvaartmaatschappijen.jsp");

        } else if (request.getParameter("knopVliegtuigen") != null) {

            ArrayList<Vliegtuig> vliegtuigen = davliegtuig.getVliegtuigen();
            request.setAttribute("vliegtuigen", vliegtuigen);

            rd = request.getRequestDispatcher("Admin/vliegtuigen.jsp");

        } else if (request.getParameter("knopHangars") != null) {

            ArrayList<Hangar> hangars = dahangar.getHangars();
            request.setAttribute("hangars", hangars);

            rd = request.getRequestDispatcher("Admin/hangars.jsp");

        } else if (request.getParameter("knopBemanning") != null) {

            ArrayList<Bemanningslid> bemanningsleden = dabemanningslid.getBemanningsleden();
            request.setAttribute("bemanningsleden", bemanningsleden);

            rd = request.getRequestDispatcher("Admin/bemanning.jsp");
        } else if (request.getParameter("knopVluchtbemanning") != null) {

            ArrayList<Vluchtbemanning> vluchtbemanningen = davluchtbemanning.getVluchtbemanningen();
            request.setAttribute("vluchtbemanningen", vluchtbemanningen);

            rd = request.getRequestDispatcher("Admin/vluchtbemanning.jsp");
        } else if (request.getParameter("knopVliegtuigenInHangars") != null) {

            ArrayList<Stockage> stockages = dastockage.getStockages();
            request.setAttribute("stockages", stockages);

            rd = request.getRequestDispatcher("Admin/stockages.jsp");
        } else if (request.getParameter("luchthavenToevoegen") != null) {

            if (request.getParameter("luchthavenToevoegen").equals("Toevoegen")) {
                String naam = request.getParameter("naam");
                String stad = request.getParameter("stad");

                int landid = Integer.parseInt(request.getParameter("selectLand"));

                if (daluchthaven.addLuchthaven(naam, stad, landid)) {
                    ArrayList<Luchthaven> luchthavens = daluchthaven.getLuchthavens();

                    rd = request.getRequestDispatcher("Admin/luchthavens.jsp");
                    request.setAttribute("luchthavens", luchthavens);
                } else {
                    rd = request.getRequestDispatcher("Admin/luchthavenToevoegen.jsp");

                    ArrayList<Land> landen = dalanden.getLanden();
                    request.setAttribute("landen", landen);
                }

            } else {
                rd = request.getRequestDispatcher("Admin/luchthavenToevoegen.jsp");

                ArrayList<Land> landen = dalanden.getLanden();
                request.setAttribute("landen", landen);
            }

        } else if (request.getParameter("luchthavenAanpassen") != null) {

            if (request.getParameter("luchthavenAanpassen").equals("Aanpassen")) {
                int id = Integer.parseInt(request.getParameter("luchthavenid"));

                String naam = request.getParameter("naam");
                String stad = request.getParameter("stad");
                int landid = Integer.parseInt(request.getParameter("selectLand"));

                if (daluchthaven.updateLuchthaven(id, naam, stad, landid)) {
                    ArrayList<Luchthaven> luchthavens = daluchthaven.getLuchthavens();

                    rd = request.getRequestDispatcher("Admin/luchthavens.jsp");
                    request.setAttribute("luchthavens", luchthavens);
                } else {
                    rd = request.getRequestDispatcher("error.jsp");
                    request.setAttribute("fout", "Wijzigen luchthaven mislukt");
                }

            } else {
                int id = Integer.parseInt(request.getParameter("luchthavenAanpassen"));

                Luchthaven luchthaven = daluchthaven.getLuchthaven(id);
                request.setAttribute("luchthaven", luchthaven);

                ArrayList<Land> landen = dalanden.getLanden();
                request.setAttribute("landen", landen);

                rd = request.getRequestDispatcher("Admin/luchthavenAanpassen.jsp");
            }

        } else if (request.getParameter("luchthavenVerwijderen") != null) {

            int id = Integer.parseInt(request.getParameter("luchthavenVerwijderen"));

            if (daluchthaven.deleteLuchthaven(id)) {
                ArrayList<Luchthaven> luchthavens = daluchthaven.getLuchthavens();

                rd = request.getRequestDispatcher("Admin/luchthavens.jsp");
                request.setAttribute("luchthavens", luchthavens);
            } else {
                request.setAttribute("fout", "Verwijderen luchthaven niet gelukt");
                rd = request.getRequestDispatcher("error.jsp");
            }

        } else if (request.getParameter("luchtvaartmaatschappijToevoegen") != null) {

            if (request.getParameter("luchtvaartmaatschappijToevoegen").equals("Toevoegen")) {
                String naam = request.getParameter("naam");
                if (daluchtvaartmaatschappij.addLuchtvaartmaatschappij(naam)) {
                    ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
                    request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

                    rd = request.getRequestDispatcher("Admin/luchtvaartmaatschappijen.jsp");
                } else {
                    rd = request.getRequestDispatcher("Admin/luchtvaartmaatschappijToevoegen.jsp");
                }
            } else {
                rd = request.getRequestDispatcher("Admin/luchtvaartmaatschappijToevoegen.jsp");
            }
        } else if (request.getParameter("luchtvaartmaatschappijAanpassen") != null) {

            if (request.getParameter("luchtvaartmaatschappijAanpassen").equals("Aanpassen")) {

                int id = Integer.parseInt(request.getParameter("luchtvaartmaatschappijid"));
                String naam = request.getParameter("naam");

                if (daluchtvaartmaatschappij.updateLuchtvaartmaatschappij(id, naam)) {
                    ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
                    request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

                    rd = request.getRequestDispatcher("Admin/luchtvaartmaatschappijen.jsp");
                } else {
                    rd = request.getRequestDispatcher("error.jsp");
                    request.setAttribute("fout", "Wijzigen luchtvaartmaatschappij mislukt");
                }
            } else {
                int id = Integer.parseInt(request.getParameter("luchtvaartmaatschappijAanpassen"));

                Luchtvaartmaatschappij luchtvaartmaatschappij = daluchtvaartmaatschappij.getLuchtvaartmaatschappij(id);
                request.setAttribute("luchtvaartmaatschappij", luchtvaartmaatschappij);

                rd = request.getRequestDispatcher("Admin/luchtvaartmaatschappijAanpassen.jsp");
            }
        } else if (request.getParameter("luchtvaartmaatschappijVerwijderen") != null) {

            int id = Integer.parseInt(request.getParameter("luchtvaartmaatschappijVerwijderen"));

            if (daluchtvaartmaatschappij.deleteLuchtvaartmaatschappij(id)) {

                ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
                request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

                rd = request.getRequestDispatcher("Admin/luchtvaartmaatschappijen.jsp");
            } else {
                rd = request.getRequestDispatcher("error.jsp");
                request.setAttribute("fout", "Verwijderen luchtvaartmaatschappij mislukt");
            }

        } else if (request.getParameter("vliegtuigToevoegen") != null) {

            if (request.getParameter("vliegtuigToevoegen").equals("Toevoegen")) {

                int vliegtuigtypeid = Integer.parseInt(request.getParameter("selectVliegtuigtype"));
                int luchtvaartmaatschappijid = Integer.parseInt(request.getParameter("selectLuchtvaartmaatschappij"));

                if (davliegtuig.addVliegtuig(vliegtuigtypeid, luchtvaartmaatschappijid)) {
                    ArrayList<Vliegtuig> vliegtuigen = davliegtuig.getVliegtuigen();
                    request.setAttribute("vliegtuigen", vliegtuigen);

                    rd = request.getRequestDispatcher("Admin/vliegtuigen.jsp");
                } else {
                    rd = request.getRequestDispatcher("Admin/vliegtuigToevoegen.jsp");

                    ArrayList<Vliegtuigtype> vliegtuigtypes = davliegtuigtype.getVliegtuigtypes();
                    request.setAttribute("vliegtuigtypes", vliegtuigtypes);

                    ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
                    request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);
                }

            } else {
                rd = request.getRequestDispatcher("Admin/vliegtuigToevoegen.jsp");

                ArrayList<Vliegtuigtype> vliegtuigtypes = davliegtuigtype.getVliegtuigtypes();
                request.setAttribute("vliegtuigtypes", vliegtuigtypes);

                ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
                request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

            }
        } else if (request.getParameter("vliegtuigAanpassen") != null) {

            if (request.getParameter("vliegtuigAanpassen").equals("Aanpassen")) {

                int id = Integer.parseInt(request.getParameter("vliegtuigid"));

                int vliegtuigtypeid = Integer.parseInt(request.getParameter("selectVliegtuigtype"));
                int luchtvaartmaatschappijid = Integer.parseInt(request.getParameter("selectLuchtvaartmaatschappij"));

                if (davliegtuig.updateVliegtuig(id, vliegtuigtypeid, luchtvaartmaatschappijid)) {
                    ArrayList<Vliegtuig> vliegtuigen = davliegtuig.getVliegtuigen();
                    request.setAttribute("vliegtuigen", vliegtuigen);

                    rd = request.getRequestDispatcher("Admin/vliegtuigen.jsp");
                } else {
                    rd = request.getRequestDispatcher("error.jsp");
                    request.setAttribute("fout", "Wijzigen vliegtuig mislukt");
                }

            } else {
                int id = Integer.parseInt(request.getParameter("vliegtuigAanpassen"));

                Vliegtuig vliegtuig = davliegtuig.getVliegtuig(id);
                request.setAttribute("vliegtuig", vliegtuig);

                ArrayList<Vliegtuigtype> vliegtuigtypes = davliegtuigtype.getVliegtuigtypes();
                request.setAttribute("vliegtuigtypes", vliegtuigtypes);

                ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
                request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

                rd = request.getRequestDispatcher("Admin/vliegtuigAanpassen.jsp");
            }

        } else if (request.getParameter("vliegtuigVerwijderen") != null) {

            int id = Integer.parseInt(request.getParameter("vliegtuigVerwijderen"));

            if (davliegtuig.deleteVliegtuig(id)) {
                ArrayList<Vliegtuig> vliegtuigen = davliegtuig.getVliegtuigen();
                request.setAttribute("vliegtuigen", vliegtuigen);

                rd = request.getRequestDispatcher("Admin/vliegtuigen.jsp");
            } else {
                rd = request.getRequestDispatcher("error.jsp");
                request.setAttribute("fout", "Verwijderen vliegtuig mislukt");
            }
        } else if (request.getParameter("hangarToevoegen") != null) {

            if (request.getParameter("hangarToevoegen").equals("Toevoegen")) {
                String naam = request.getParameter("naam");

                if (dahangar.addHangar(naam)) {
                    ArrayList<Hangar> hangars = dahangar.getHangars();
                    request.setAttribute("hangars", hangars);

                    rd = request.getRequestDispatcher("Admin/hangars.jsp");
                } else {
                    rd = request.getRequestDispatcher("Admin/hangarToevoegen.jsp");
                }
            } else {
                rd = request.getRequestDispatcher("Admin/hangarToevoegen.jsp");
            }

        } else if (request.getParameter("hangarAanpassen") != null) {

            if (request.getParameter("hangarAanpassen").equals("Aanpassen")) {

                int id = Integer.parseInt(request.getParameter("hangarid"));
                String naam = request.getParameter("naam");

                if (dahangar.updateHangar(id, naam)) {
                    ArrayList<Hangar> hangars = dahangar.getHangars();
                    request.setAttribute("hangars", hangars);

                    rd = request.getRequestDispatcher("Admin/hangars.jsp");
                } else {
                    rd = request.getRequestDispatcher("error.jsp");
                    request.setAttribute("fout", "Wijzigen hangar mislukt");
                }
            } else {
                int id = Integer.parseInt(request.getParameter("hangarAanpassen"));

                Hangar hangar = dahangar.getHangar(id);
                request.setAttribute("hangar", hangar);

                rd = request.getRequestDispatcher("Admin/hangarAanpassen.jsp");
            }

        } else if (request.getParameter("hangarVerwijderen") != null) {

            int id = Integer.parseInt(request.getParameter("hangarVerwijderen"));

            if (dahangar.deleteHangar(id)) {
                ArrayList<Hangar> hangars = dahangar.getHangars();
                request.setAttribute("hangars", hangars);

                rd = request.getRequestDispatcher("Admin/hangars.jsp");
            } else {
                rd = request.getRequestDispatcher("error.jsp");
                request.setAttribute("fout", "Verwijderen hangar mislukt");
            }
        } else if (request.getParameter("bemanningslidToevoegen") != null) {

            if (request.getParameter("bemanningslidToevoegen").equals("Toevoegen")) {

                int functieid = Integer.parseInt(request.getParameter("selectFunctie"));
                int persoonid = Integer.parseInt(request.getParameter("selectPersoon"));
                int luchtvaartmaatschappijid = Integer.parseInt(request.getParameter("selectLuchtvaartmaatschappij"));

                if (dabemanningslid.addBemanningslid(functieid, persoonid, luchtvaartmaatschappijid)) {
                    ArrayList<Bemanningslid> bemanningsleden = dabemanningslid.getBemanningsleden();
                    request.setAttribute("bemanningsleden", bemanningsleden);

                    rd = request.getRequestDispatcher("Admin/bemanning.jsp");
                } else {
                    rd = request.getRequestDispatcher("Admin/bemanningslidToevoegen.jsp");

                    ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
                    request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

                    ArrayList<Functie> functies = dafunctie.getFuncties();
                    request.setAttribute("functies", functies);

                    ArrayList<Persoon> personen = dapersoon.getPersonen();
                    request.setAttribute("personen", personen);
                }

            } else {
                rd = request.getRequestDispatcher("Admin/bemanningslidToevoegen.jsp");

                ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
                request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

                ArrayList<Functie> functies = dafunctie.getFuncties();
                request.setAttribute("functies", functies);

                ArrayList<Persoon> personen = dapersoon.getPersonen();
                request.setAttribute("personen", personen);
            }

        } else if (request.getParameter("bemanningslidAanpassen") != null) {

            if (request.getParameter("bemanningslidAanpassen").equals("Aanpassen")) {

                int id = Integer.parseInt(request.getParameter("bemanningslidid"));

                int luchtvaartmaatschappijid = Integer.parseInt(request.getParameter("selectLuchtvaartmaatschappij"));
                int functieid = Integer.parseInt(request.getParameter("selectFunctie"));
                int persoonid = Integer.parseInt(request.getParameter("selectPersoon"));

                if (dabemanningslid.updateBemanningslid(id, functieid, persoonid, luchtvaartmaatschappijid)) {
                    ArrayList<Bemanningslid> bemanningsleden = dabemanningslid.getBemanningsleden();
                    request.setAttribute("bemanningsleden", bemanningsleden);

                    rd = request.getRequestDispatcher("Admin/bemanning.jsp");
                } else {
                    rd = request.getRequestDispatcher("error.jsp");
                    request.setAttribute("fout", "Wijzigen bemanningslid mislukt");
                }
            } else {
                int id = Integer.parseInt(request.getParameter("bemanningslidAanpassen"));

                Bemanningslid bemanningslid = dabemanningslid.getBemanningslid(id);
                request.setAttribute("bemanningslid", bemanningslid);

                ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
                request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

                ArrayList<Functie> functies = dafunctie.getFuncties();
                request.setAttribute("functies", functies);

                ArrayList<Persoon> personen = dapersoon.getPersonen();
                request.setAttribute("personen", personen);

                rd = request.getRequestDispatcher("Admin/bemanningslidAanpassen.jsp");
            }

        } else if (request.getParameter("bemanningslidVerwijderen") != null) {

            int id = Integer.parseInt(request.getParameter("bemanningslidVerwijderen"));

            if (dabemanningslid.deleteBemanningslid(id)) {
                ArrayList<Bemanningslid> bemanningsleden = dabemanningslid.getBemanningsleden();
                request.setAttribute("bemanningsleden", bemanningsleden);

                rd = request.getRequestDispatcher("Admin/bemanning.jsp");
            } else {
                rd = request.getRequestDispatcher("error.jsp");
                request.setAttribute("fout", "Verwijderen bemanningslid mislukt."
                        + System.lineSeparator()
                        + "Het bemanningslid is nog toegewezen aan een vlucht");
            }
        } else if (request.getParameter("vluchtbemanningToevoegen") != null) {

            if (request.getParameter("vluchtbemanningToevoegen").equals("Toevoegen")) {

                String taak = request.getParameter("taak");

                int vluchtid = Integer.parseInt(request.getParameter("selectVlucht"));
                int bemanningslidid = Integer.parseInt(request.getParameter("selectBemanningslid"));

                if (davluchtbemanning.addVluchtbemanning(taak, vluchtid, bemanningslidid)) {
                    ArrayList<Vluchtbemanning> vluchtbemanningen = davluchtbemanning.getVluchtbemanningen();
                    request.setAttribute("vluchtbemanningen", vluchtbemanningen);

                    rd = request.getRequestDispatcher("Admin/vluchtbemanning.jsp");
                } else {
                    rd = request.getRequestDispatcher("Admin/vluchtbemanningToevoegen.jsp");

                    ArrayList<Vlucht> vluchten = davlucht.getVluchten();
                    request.setAttribute("vluchten", vluchten);

                    ArrayList<Bemanningslid> bemanningsleden = dabemanningslid.getBemanningsleden();
                    request.setAttribute("bemanningsleden", bemanningsleden);
                }
            } else {
                rd = request.getRequestDispatcher("Admin/vluchtbemanningToevoegen.jsp");

                ArrayList<Vlucht> vluchten = davlucht.getVluchten();
                request.setAttribute("vluchten", vluchten);

                ArrayList<Bemanningslid> bemanningsleden = dabemanningslid.getBemanningsleden();
                request.setAttribute("bemanningsleden", bemanningsleden);
            }

        } else if (request.getParameter("vluchtbemanningAanpassen") != null) {

            if (request.getParameter("vluchtbemanningAanpassen").equals("Aanpassen")) {

                int id = Integer.parseInt(request.getParameter("vluchtbemanningid"));

                String taak = request.getParameter("taak");

                int vluchtid = Integer.parseInt(request.getParameter("selectVlucht"));
                int bemanningslidid = Integer.parseInt(request.getParameter("selectBemanningslid"));

                if (davluchtbemanning.updateVluchtbemanning(id, taak, vluchtid, bemanningslidid)) {
                    ArrayList<Vluchtbemanning> vluchtbemanningen = davluchtbemanning.getVluchtbemanningen();
                    request.setAttribute("vluchtbemanningen", vluchtbemanningen);

                    rd = request.getRequestDispatcher("Admin/vluchtbemanning.jsp");
                } else {
                    rd = request.getRequestDispatcher("error.jsp");
                    request.setAttribute("fout", "Wijzigen vluchtbemanning mislukt");
                }
            } else {
                int id = Integer.parseInt(request.getParameter("vluchtbemanningAanpassen"));

                Vluchtbemanning vluchtbemanning = davluchtbemanning.getVluchtbemanning(id);

                request.setAttribute("vluchtbemanning", vluchtbemanning);

                ArrayList<Vlucht> vluchten = davlucht.getVluchten();
                request.setAttribute("vluchten", vluchten);

                ArrayList<Bemanningslid> bemanningsleden = dabemanningslid.getBemanningsleden();
                request.setAttribute("bemanningsleden", bemanningsleden);

                rd = request.getRequestDispatcher("Admin/vluchtbemanningAanpassen.jsp");
            }

        } else if (request.getParameter("vluchtbemanningVerwijderen") != null) {

            int id = Integer.parseInt(request.getParameter("vluchtbemanningVerwijderen"));

            if (davluchtbemanning.deleteVluchtbemanning(id)) {
                ArrayList<Vluchtbemanning> vluchtbemanningen = davluchtbemanning.getVluchtbemanningen();
                request.setAttribute("vluchtbemanningen", vluchtbemanningen);

                rd = request.getRequestDispatcher("Admin/vluchtbemanning.jsp");
            } else {
                rd = request.getRequestDispatcher("error.jsp");
                request.setAttribute("fout", "Verwijderen vluchtbemanning mislukt.");
            }
        } else if (request.getParameter("stockageToevoegen") != null) {

            if (request.getParameter("stockageToevoegen").equals("Toevoegen")) {

                String reden = request.getParameter("reden");

                String vandatumstring = request.getParameter("vandatum");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate vandatum = LocalDate.parse(vandatumstring, formatter);

                String totdatumstring = request.getParameter("totdatum");
                LocalDate totdatum = LocalDate.parse(totdatumstring, formatter);

                int vliegtuigid = Integer.parseInt(request.getParameter("selectVliegtuig"));
                int hangarid = Integer.parseInt(request.getParameter("selectHangar"));

                if (dastockage.addStockage(reden, vandatum, totdatum, vliegtuigid, hangarid)) {

                    ArrayList<Stockage> stockages = dastockage.getStockages();
                    request.setAttribute("stockages", stockages);

                    rd = request.getRequestDispatcher("Admin/stockages.jsp");
                } else {
                    rd = request.getRequestDispatcher("Admin/stockageToevoegen.jsp");

                    ArrayList<Vliegtuig> vliegtuigen = davliegtuig.getVliegtuigen();
                    request.setAttribute("vliegtuigen", vliegtuigen);

                    ArrayList<Hangar> hangars = dahangar.getHangars();
                    request.setAttribute("hangars", hangars);
                }

            } else {
                rd = request.getRequestDispatcher("Admin/stockageToevoegen.jsp");

                ArrayList<Vliegtuig> vliegtuigen = davliegtuig.getVliegtuigen();
                request.setAttribute("vliegtuigen", vliegtuigen);

                ArrayList<Hangar> hangars = dahangar.getHangars();
                request.setAttribute("hangars", hangars);
            }

        } else if (request.getParameter("stockageAanpassen") != null) {

            if (request.getParameter("stockageAanpassen").equals("Aanpassen")) {

                int id = Integer.parseInt(request.getParameter("stockageid"));

                String reden = request.getParameter("reden");

                String vandatumstring = request.getParameter("vandatum");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate vandatum = LocalDate.parse(vandatumstring, formatter);

                String totdatumstring = request.getParameter("totdatum");
                LocalDate totdatum = LocalDate.parse(totdatumstring, formatter);

                int vliegtuigid = Integer.parseInt(request.getParameter("selectVliegtuig"));
                int hangarid = Integer.parseInt(request.getParameter("selectHangar"));

                if (dastockage.updateStockage(id, reden, vandatum, totdatum, vliegtuigid, hangarid)) {
                    ArrayList<Stockage> stockages = dastockage.getStockages();
                    request.setAttribute("stockages", stockages);

                    rd = request.getRequestDispatcher("Admin/stockages.jsp");
                } else {
                    rd = request.getRequestDispatcher("error.jsp");
                    request.setAttribute("fout", "Wijzigen stockage mislukt");
                }
            } else {
                int id = Integer.parseInt(request.getParameter("stockageAanpassen"));

                Stockage stockage = dastockage.getStockage(id);
                request.setAttribute("stockage", stockage);

                ArrayList<Vliegtuig> vliegtuigen = davliegtuig.getVliegtuigen();
                request.setAttribute("vliegtuigen", vliegtuigen);

                ArrayList<Hangar> hangars = dahangar.getHangars();
                request.setAttribute("hangars", hangars);

                rd = request.getRequestDispatcher("Admin/stockageAanpassen.jsp");
            }

        } else if (request.getParameter("stockageVerwijderen") != null) {

            int id = Integer.parseInt(request.getParameter("stockageVerwijderen"));

            if (dastockage.deleteStockage(id)) {
                ArrayList<Stockage> stockages = dastockage.getStockages();
                request.setAttribute("stockages", stockages);

                rd = request.getRequestDispatcher("Admin/stockages.jsp");
            } else {
                rd = request.getRequestDispatcher("error.jsp");
                request.setAttribute("fout", "Verwijderen stockage mislukt.");
            }
        } else if (request.getParameter("knopStatistiekenOpvragen") != null) {

            ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
            request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

            ArrayList<Luchthaven> luchthavens = daluchthaven.getLuchthavens();
            request.setAttribute("luchthavens", luchthavens);

            ArrayList<Vlucht> vluchten = davlucht.getVluchten();
            request.setAttribute("vluchten", vluchten);

            rd = request.getRequestDispatcher("Admin/statistieken.jsp");

            request.setAttribute("leeftijd", "hidden");
            request.setAttribute("bestemming", "hidden");

        } else if (request.getParameter("knopStatistiekenLuchtvaartmaatschappij") != null) {
            int id = Integer.parseInt(request.getParameter("selectLuchtvaartmaatschappij"));

            ArrayList<Vlucht> vluchten = davlucht.getVluchtenPerLuchtvaartmaatschappij(id);

            Map<String, Integer> passagiersPerVlucht = new HashMap<String, Integer>();
            Map<String, Integer> passagiersPerDag = new HashMap<String, Integer>();
            Map<String, Integer> passagiersPerMaand = new HashMap<String, Integer>();

            for (Vlucht vlucht : vluchten) {
                passagiersPerVlucht.put(vlucht.getCode(), davlucht.getAantalPassagiers(vlucht.getId()));

                java.sql.Date datum = vlucht.getVertrektijd();
                boolean dagBestaatAl = false;
                for (String dag : passagiersPerDag.keySet()) {
                    if (dag.equals(datum.toLocalDate().toString())) {
                        dagBestaatAl = true;
                    }
                }
                if (dagBestaatAl) {
                    int newValue = passagiersPerDag.get(datum.toLocalDate().toString()) + davlucht.getAantalPassagiers(vlucht.getId());
                    passagiersPerDag.replace(datum.toLocalDate().toString(), newValue);
                } else {
                    passagiersPerDag.put(datum.toLocalDate().toString(), davlucht.getAantalPassagiers(vlucht.getId()));
                }

                YearMonth maand = YearMonth.of(datum.toLocalDate().getYear(), datum.toLocalDate().getMonth());
                boolean maandBestaatAl = false;
                for (String maandInSet : passagiersPerMaand.keySet()) {
                    if (maandInSet.equals(maand.toString())) {
                        maandBestaatAl = true;
                    }
                }
                if (maandBestaatAl) {
                    int newValue = passagiersPerMaand.get(maand.toString()) + davlucht.getAantalPassagiers(vlucht.getId());
                    passagiersPerMaand.replace(maand.toString(), newValue);
                } else {
                    passagiersPerMaand.put(maand.toString(), davlucht.getAantalPassagiers(vlucht.getId()));
                }
            }

            Luchtvaartmaatschappij luchtvaartmaatschappij = daluchtvaartmaatschappij.getLuchtvaartmaatschappij(id);
            request.setAttribute("passagiersvoor", luchtvaartmaatschappij.getLuchtvaartnaam());

            request.setAttribute("passagiersPerDag", passagiersPerDag);
            request.setAttribute("passagiersPerMaand", passagiersPerMaand);
            request.setAttribute("passagiersPerVlucht", passagiersPerVlucht);

            rd = request.getRequestDispatcher("Admin/passagierStatistieken.jsp");

        } else if (request.getParameter("knopStatistiekenLuchthaven") != null) {
            int id = Integer.parseInt(request.getParameter("selectLuchthaven"));

            ArrayList<Vlucht> vluchten = davlucht.getVluchtenPerLuchthaven(id);

            Map<String, Integer> passagiersPerVlucht = new HashMap<String, Integer>();
            Map<String, Integer> passagiersPerDag = new HashMap<String, Integer>();
            Map<String, Integer> passagiersPerMaand = new HashMap<String, Integer>();

            for (Vlucht vlucht : vluchten) {
                passagiersPerVlucht.put(vlucht.getCode(), davlucht.getAantalPassagiers(vlucht.getId()));

                java.sql.Date datum = vlucht.getVertrektijd();
                boolean dagBestaatAl = false;
                for (String dag : passagiersPerDag.keySet()) {
                    if (dag.equals(datum.toLocalDate().toString())) {
                        dagBestaatAl = true;
                    }
                }
                if (dagBestaatAl) {
                    int newValue = passagiersPerDag.get(datum.toLocalDate().toString()) + davlucht.getAantalPassagiers(vlucht.getId());
                    passagiersPerDag.replace(datum.toLocalDate().toString(), newValue);
                } else {
                    passagiersPerDag.put(datum.toLocalDate().toString(), davlucht.getAantalPassagiers(vlucht.getId()));
                }

                YearMonth maand = YearMonth.of(datum.toLocalDate().getYear(), datum.toLocalDate().getMonth());
                boolean maandBestaatAl = false;
                for (String maandInSet : passagiersPerMaand.keySet()) {
                    if (maandInSet.equals(maand.toString())) {
                        maandBestaatAl = true;
                    }
                }
                if (maandBestaatAl) {
                    int newValue = passagiersPerMaand.get(maand.toString()) + davlucht.getAantalPassagiers(vlucht.getId());
                    passagiersPerMaand.replace(maand.toString(), newValue);
                } else {
                    passagiersPerMaand.put(maand.toString(), davlucht.getAantalPassagiers(vlucht.getId()));
                }
            }

            Luchthaven luchthaven = daluchthaven.getLuchthaven(id);
            request.setAttribute("passagiersvoor", luchthaven.getLuchthavennaam());

            request.setAttribute("passagiersPerDag", passagiersPerDag);
            request.setAttribute("passagiersPerMaand", passagiersPerMaand);
            request.setAttribute("passagiersPerVlucht", passagiersPerVlucht);

            rd = request.getRequestDispatcher("Admin/passagierStatistieken.jsp");

        } else if (request.getParameter("knopStatistiekenLeeftijd") != null) {
            int id = Integer.parseInt(request.getParameter("selectBestemming"));

            int gemLeeftijd = dapassagier.getGemiddeldeLeeftijdPerBestemming(id);

            Luchthaven luchthaven = daluchthaven.getLuchthaven(id);
            request.setAttribute("bestemming", luchthaven.getLuchthavennaam());
            request.setAttribute("leeftijd", Integer.toString(gemLeeftijd));

            ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daluchtvaartmaatschappij.getLuchtvaartmaatschappijen();
            request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

            ArrayList<Luchthaven> luchthavens = daluchthaven.getLuchthavens();
            request.setAttribute("luchthavens", luchthavens);

            ArrayList<Vlucht> vluchten = davlucht.getVluchten();
            request.setAttribute("vluchten", vluchten);

            rd = request.getRequestDispatcher("Admin/statistieken.jsp");

        } else if (request.getParameter("knopStatistiekenVlucht") != null) {
            int id = Integer.parseInt(request.getParameter("selectVlucht"));

//todo
        }

        rd.forward(request, response);

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
