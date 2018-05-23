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
    </head>
    <body>
        <% Persoon p = (Persoon) session.getAttribute("currentSessionUser");%>
        <% ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) session.getAttribute(("vluchten"));%>
        <p>Welkom <%=p.getVoornaam()%></p>
        <p>Zie hieronder het reisschema voor uw komende weken.</p>
        <table>
            <thead>
                <th>Vlucht ID</th>
                <th>Vertrektijd</th>
                <th>Aankomsttijd</th>
                <th>Vliegtuig ID</th>
                <th>Vertrek Luchthaven</th>
                <th>Aankomst luchthaven</th>
                <th>Passagierlijst</th>
            </thead>
            <tbody>
                <%for (int i = 0; i < vluchten.size(); i++) {
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
                   out.println("<button name='btnPassagierLijst' value='" + id + "' onclick=''");
                }%>
            </tbody>
        </table>
    </body>
</html>
