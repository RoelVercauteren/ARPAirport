/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.dataaccess.DAPassagier;
import hbo5.it.www.dataaccess.DAPersoon;
import hbo5.it.www.dataaccess.DAVlucht;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author andre
 */
@WebServlet(name = "ManageServlet", urlPatterns = {"/ManageServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "C1042431")
    , @WebInitParam(name = "paswoord", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class ManageServlet extends HttpServlet {

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
    private DAPersoon dapersoon = null;
    private DAPassagier dapassagier = null;

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
            if (dapersoon == null) {
                dapersoon = new DAPersoon(url, login, paswoord, driver);
            }
            if (dapassagier == null) {
                dapassagier = new DAPassagier(url, login, paswoord, driver);
            }

        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Persoon p = new Persoon();
        HttpSession session = request.getSession();
        p = (Persoon) session.getAttribute("currentSessionUser");
        if (session.getAttribute("servlet").equals("y")) {
            if (p.getSoort().equals("P")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomePassagier.jsp");
                session.setAttribute("servlet", "");
                dispatcher.forward(request, response);

            } else if (p.getSoort().equals("B")) {
                session.setAttribute("servlet", "");
                ArrayList<Vlucht> vluchten = davlucht.getVluchtenVoorBemanning(p.getId());
                session.setAttribute("vluchten", vluchten);
                response.sendRedirect("bemanningslid.jsp");
            }
            else {
                response.sendRedirect("admin.jsp");
            }

            /**
             * Processes requests for both HTTP <code>GET</code> and
             * <code>POST</code> methods.
             *
             * @param request servlet request
             * @param response servlet response
             * @throws ServletException if a servlet-specific error occurs
             * @throws IOException if an I/O error occurs
             */
        } else {
            RequestDispatcher rd = null;

            p = (Persoon) session.getAttribute("currentSessionUser");

            if (request.getParameter("knopGeboekte") != null) {
                String stringId = String.valueOf(p.getId());
                ArrayList<Vlucht> geboektevluchten = dapersoon.getVluchtenByPersoon(stringId);
                request.setAttribute("geboekteVluchten", geboektevluchten);
                rd = request.getRequestDispatcher("Passagier/VluchtenVanPassagier.jsp");
                rd.forward(request, response);

            } else if (request.getParameter("knopAlleVluchten") != null) {
                
                try {
                    ArrayList<Vlucht> vluchten = davlucht.getVluchten();
                    request.setAttribute("vluchten", vluchten);
                    rd = request.getRequestDispatcher("vluchten.jsp");
                    rd.forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (request.getParameter("passagierlijstvlucht") != null){
                int id= Integer.parseInt(request.getParameter("passagierlijstvlucht"));
                request.setAttribute("passagiers", dapassagier.getPassagiersVlucht(id));
                rd = request.getRequestDispatcher("passagierlijst.jsp");
                rd.forward(request, response);
            }
            else {
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
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
    }
}
