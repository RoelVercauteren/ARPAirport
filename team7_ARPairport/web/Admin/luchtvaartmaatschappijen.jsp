<%-- 
    Document   : luchtvaartmaatschappijen
    Created on : 8-mei-2018, 14:46:29
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Luchtvaartmaatschappijen Beheren</title>

        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">

        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:800px;
                margin: 0 auto;
            }
        </style>       

        <% ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("luchtvaartmaatschappijen");%>   
    </head>
    <body>
        <h1>Luchtvaartmaatschappijen Beheren</h1>

        <form action="AdminServlet">
            <input type="submit" value="Luchtvaartmaatschappij Toevoegen" name="luchtvaartmaatschappijToevoegen" />
        </form>

        <table class="redTable">

            <% for (Luchtvaartmaatschappij luchtvaartmaatschappij : luchtvaartmaatschappijen) {%>

            <tr>
                <td><%=luchtvaartmaatschappij.getLuchtvaartnaam()%></td>
                <td>
                    <a href ="AdminServlet?luchtvaartmaatschappijAanpassen=<%=luchtvaartmaatschappij.getId()%>">
                        <input type="submit" name="luchtvaartmaatschappijAanpassen" value="Aanpassen">
                    </a>
                </td>
                <td>
                    <a href ="AdminServlet?luchtvaartmaatschappijVerwijderen=<%=luchtvaartmaatschappij.getId()%>">
                        <input type="submit" name="luchtvaartmaatschappijVerwijderen" value="Verwijderen">
                    </a>
                </td>
            </tr>

            <% }%>

        </table>

        <p><a href="admin.jsp">Terug</a></p>

    </body>
</html>
