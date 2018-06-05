<%-- 
    Document   : vluchten
    Created on : 24-apr-2018, 15:09:58
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.VluchtComparator"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uw vluchten</title>

        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">

        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:1200px;
                margin: 0 auto;
            }
        </style>

    </head>
    <body>
        <h1>Uw vluchten</h1>

        <% ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) request.getAttribute("geboekteVluchten"); %>
       <!--  vluchten.sort(new VluchtComparator());  -->

        <table border="1" class="redTable">
            <tr>
                <th>Code</th>
                <th>Vertrekplaats</th>
                <th>Vertrektijd</th>
                <th>Aankomstplaats</th>
                <th>Aankomsttijd</th>
                <th>Luchtvaartmaatschappij</th>
                <th>Meer Details</th>
                <th></th>
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
                        <input type="hidden" name="vluchtid" value="<%=vlucht.getId()%>" />  
                        <input type="submit" value="Toon Details" name="toonMeerDetails" />
                    </form>
                </td>
                <td>
                    <form action="ManageServlet">
                        <input type="hidden" name="vluchtid" value="<%=vlucht.getId()%>" />  
                        <input type="submit" value="Annuleren" name="annuleren" />
                    </form></td>
            </tr>
            <% }%>
        </table>


        <p><a href="WelcomePassagier.jsp">Terug</a></p>

    </body>
</html>
