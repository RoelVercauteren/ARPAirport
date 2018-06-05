<%-- 
    Document   : bemanningslid
    Created on : May 16, 2018, 8:59:18 AM
    Author     : 3230059
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/formstyle.css">
        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">
        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:1200px;
                margin: 0 auto;
            }
            p {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <% Persoon p = (Persoon) session.getAttribute("currentSessionUser");%>
        <% ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) session.getAttribute(("vluchten"));%>
        <h1>Welkom <%=p.getVoornaam()%></h1> 

        <%if (vluchten != null) {
                out.println("<p>Zie hieronder het reisschema voor uw komende weken.</p>");
                out.println("<table class='redTable'>");
                out.println("<th>Vlucht ID</th>");
                out.println("<th>Vertrektijd</th>");
                out.println("<th>Aankomsttijd</th>");
                out.println("<th>Vliegtuig ID</th>");
                out.println("<th>Vertrek Luchthaven</th>");
                out.println("<th>Aankomst luchthaven</th>");
                out.println("<th>Passagierlijst</th>");

                for (int i = 0; i < vluchten.size(); i++) {
                    int id = vluchten.get(i).getId();
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(vluchten.get(i).getId());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(vluchten.get(i).getVertrektijd());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(vluchten.get(i).getAankomsttijd());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(vluchten.get(i).getVliegtuig_id());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(vluchten.get(i).getVertrekluchthaven().getLuchthavennaam());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(vluchten.get(i).getAankomstluchthaven().getLuchthavennaam());
                    out.println("</td>");
                    out.print("<input type='submit' name='");
                    out.print(vluchten.get(i).getId());
                    out.print("' value='Passagierlijst'");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else {
                out.println("<p>U heeft geen toekomstige vluchten op uw schema.</p>");
            }
        %>
    </body>
</html>
