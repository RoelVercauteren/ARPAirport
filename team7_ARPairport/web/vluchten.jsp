<%-- 
    Document   : vluchten
    Created on : 24-apr-2018, 15:09:58
    Author     : roel_
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overzicht vluchten</title>
    </head>
    <body>
        <h1>Vluchten</h1>

        <% ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) request.getAttribute("vluchten"); %>

        <table border="1">
            <tr>
                <th>Code</th>
                <th>Vertrekplaats</th>
                <th>Vertrektijd</th>
                <th>Aankomstplaats</th>
                <th>Aankomsttijd</th>
                <th>Luchtvaartmaatschappij</th>
                <th>Meer Details</th>
            </tr>

            <% for (Vlucht vlucht : vluchten) {%>
            <tr>
                <td><%=vlucht.getCode()%></td>
                <td><%=vlucht.getVertrekluchthaven().getLuchthavennaam()%> - <%=vlucht.getVertrekluchthaven().getStad()%></td>
                <td><%=vlucht.getVertrektijd().toLocaleString()%></td>    
                <td><%=vlucht.getAankomstluchthaven().getLuchthavennaam()%> - <%=vlucht.getAankomstluchthaven().getStad()%></td>
                <td><%=vlucht.getAankomsttijd().toLocaleString()%></td>
                <td><%=vlucht.getVliegtuig().getLuchtvaartmaatschappij().getLuchtvaartnaam()%></td>
                <td>
                    <form action="ZoekServlet">
                        <input type="hidden" name="vluchtid" value="<%=vlucht.getId()%>">  
                        <input type="submit" value="Toon Details" name="toonMeerDetails" />
                    </form>
                </td>
            </tr>
            <% }%>
        </table>


        <a href="ZoekServlet?zoekKnop">Terug</a>

    </body>
</html>
