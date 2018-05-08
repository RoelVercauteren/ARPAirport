/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.dataaccess.DALuchthaven;
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
            rd = request.getRequestDispatcher("Admin/luchtvaartmaatschappijen.jsp");
        } else if (request.getParameter("knopVliegtuigen") != null) {
            rd = request.getRequestDispatcher("Admin/vliegtuigen.jsp");
        } else if (request.getParameter("knopHangars") != null) {
            rd = request.getRequestDispatcher("Admin/hangars.jsp");
        } else if (request.getParameter("knopBemanning") != null) {
            rd = request.getRequestDispatcher("Admin/bemanning.jsp");
        } else if (request.getParameter("knopVluchtbemanning") != null) {
            rd = request.getRequestDispatcher("Admin/vluchtbemanning.jsp");
        } else if (request.getParameter("knopVliegtuigenInHangars") != null) {
            rd = request.getRequestDispatcher("Admin/vliegtuigenInHangars.jsp");
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
