/*http://met.guc.edu.eg/OnlineTutorials/JSP%20-%20Servlets/Full%20Login%20Example.aspx
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Persoon;
import hbo5.it.www.dataaccess.DAPersoon;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 3230059
 */
@WebServlet(name = "InlogServlet", urlPatterns = {"/InlogServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "C1042424")
    , @WebInitParam(name = "paswoord", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})

public class InlogServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InlogServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InlogServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("Login") != null) {
            try {
                request.setAttribute("servlet", "yes");
                request.removeAttribute("fout");
                String url = getInitParameter("url");
                String login = getInitParameter("login");
                String password = getInitParameter("paswoord");
                String driver = getInitParameter("driver");
                DAPersoon dap = new DAPersoon(url, login, password, driver);
                Persoon user = new Persoon();
                user.setLogin(request.getParameter("Username"));
                user.setPaswoord(request.getParameter("Password"));

                user = dap.login(user);
                HttpSession session = request.getSession(true);

                if (user.isValid()) {
                    session.setAttribute("currentSessionUser", user);
                    response.sendRedirect("LoggedIn.jsp");
                } else {
                    session.setAttribute("result", "Uw login en/of paswoord is incorrect!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } catch (Throwable theException) {
                System.out.println(theException);
            }
        } else if (request.getParameter("register") != null) {
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else {
            //Nieuwe user aanmaken
            Persoon p = new Persoon();
            p.setVoornaam(request.getParameter("FirstName"));
            p.setFamilienaam(request.getParameter("Surname"));
            p.setStraat(request.getParameter("Street"));
            p.setHuisnr(request.getParameter("Number"));
            p.setPostcode(request.getParameter("PostalCode"));
            p.setWoonplaats(request.getParameter("Place"));
            p.setLand(request.getParameter("Country"));
            p.setLogin(request.getParameter("Login"));
            p.setPaswoord(request.getParameter("Password"));

            try {
                String datestring = request.getParameter("DateOfBirth");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dob = LocalDate.parse(datestring, formatter);
                java.sql.Date sqlDate = java.sql.Date.valueOf(dob);
                p.setGeboortedatum(sqlDate);
                DAPersoon dap = new DAPersoon(getInitParameter("url"), getInitParameter("login"), getInitParameter("paswoord"), getInitParameter("driver"));

                if (dap.insertPersoon(p)) {
                    //Succesvol geregistreerd
                    HttpSession session = request.getSession(true);
                    session.setAttribute("result", "U bent geregisteerd!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    //Foutmelding
                }

            } catch (Throwable theException) {
                System.out.println(theException);
            }

        }
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
