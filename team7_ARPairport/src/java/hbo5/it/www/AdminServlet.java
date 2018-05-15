/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vliegtuigtype;
import hbo5.it.www.dataaccess.DALand;
import hbo5.it.www.dataaccess.DALuchthaven;
import hbo5.it.www.dataaccess.DALuchtvaartmaatschappij;
import hbo5.it.www.dataaccess.DAVliegtuig;
import hbo5.it.www.dataaccess.DAVliegtuigtype;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            rd = request.getRequestDispatcher("Admin/hangars.jsp");
        } else if (request.getParameter("knopBemanning") != null) {
            rd = request.getRequestDispatcher("Admin/bemanning.jsp");
        } else if (request.getParameter("knopVluchtbemanning") != null) {
            rd = request.getRequestDispatcher("Admin/vluchtbemanning.jsp");
        } else if (request.getParameter("knopVliegtuigenInHangars") != null) {
            rd = request.getRequestDispatcher("Admin/vliegtuigenInHangars.jsp");
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
