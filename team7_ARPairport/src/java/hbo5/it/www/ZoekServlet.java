/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.dataaccess.DALuchthaven;
import hbo5.it.www.dataaccess.DAVlucht;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "ZoekServlet", urlPatterns = {"/ZoekServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "C1042431")
    , @WebInitParam(name = "paswoord", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class ZoekServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private DAVlucht davlucht = null;
    private DALuchthaven daluchthaven = null;

    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String login = getInitParameter("login");
            String paswoord = getInitParameter("paswoord");
            String driver = getInitParameter("driver");

            if (davlucht == null) {
                davlucht = new DAVlucht(url, login, paswoord, driver);
            }
            if (daluchthaven == null) {
                daluchthaven = new DALuchthaven(url, login, paswoord, driver);
            }

        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd = null;

        if (request.getParameter("zoekKnop") != null) {

            ArrayList<Luchthaven> luchthavens = daluchthaven.getLuchthavens();

            rd = request.getRequestDispatcher("zoek.jsp");
            request.setAttribute("luchthavens", luchthavens);
        } else if (request.getParameter("zoekBinnenkomendeVluchtenKnop") != null) {
            int luchthavenid = Integer.parseInt(request.getParameter("selectLuchthaven"));
            ArrayList<Vlucht> vluchten = davlucht.getBinnenkomendeVluchten(luchthavenid);

            rd = request.getRequestDispatcher("vluchten.jsp");
            request.setAttribute("vluchten", vluchten);

        } else if (request.getParameter("zoekVertrekkendeVluchtenKnop") != null) {
            int luchthavenid = Integer.parseInt(request.getParameter("selectLuchthaven"));
            ArrayList<Vlucht> vluchten = davlucht.getVertrekkendeVluchten(luchthavenid);

            rd = request.getRequestDispatcher("vluchten.jsp");
            request.setAttribute("vluchten", vluchten);
        } else if (request.getParameter("zoekVluchtenMetFilter") != null) {
            String code = request.getParameter("vluchtcode");

            String datestring = request.getParameter("datum");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate datum = LocalDate.parse(datestring, formatter);

            String bestemming = request.getParameter("bestemming");;
            String luchtvaartmaatschappij = request.getParameter("luchtvaartmaatschappij");;
             
            ArrayList<Vlucht> vluchten = davlucht.GetFilteredVluchten(code, datum, bestemming, luchtvaartmaatschappij);;

            rd = request.getRequestDispatcher("vluchten.jsp");
            request.setAttribute("vluchten", vluchten);
        } else if (request.getParameter("toonMeerDetails") != null) {
            int id = Integer.parseInt(request.getParameter("vluchtid"));

            Vlucht vlucht = davlucht.getVlucht(id);

            rd = request.getRequestDispatcher("vluchtDetails.jsp");
            request.setAttribute("vlucht", vlucht);

            int aantalPassagiers = davlucht.getAantalPassagiers(id);
            request.setAttribute("aantalPassagiers", aantalPassagiers);

            String piloot = davlucht.getPilootNaam(id);
            request.setAttribute("piloot", piloot);
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
