<%-- 
    Document   : vliegtuigen
    Created on : 8-mei-2018, 14:47:53
    Author     : roel_
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vliegtuig"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vliegtuigen Beheren</title>

        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">

        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:800px;
                margin: 0 auto;
            }
        </style>

        <% ArrayList<Vliegtuig> vliegtuigen = (ArrayList<Vliegtuig>) request.getAttribute("vliegtuigen");%>   

    </head>
    <body>
        <h1>Vliegtuigen Beheren</h1>


        <form action="AdminServlet">
            <input type="submit" value="Vliegtuig Toevoegen" name="vliegtuigToevoegen" />
        </form>

        <table class="redTable">
            <tr>
                <th>Type</th>
                <th>Luchtvaartmaatschappij</th>
                <th></th>
            </tr>

            <% for (Vliegtuig vliegtuig : vliegtuigen) {%>

            <tr>
                <td><%=vliegtuig.getVliegtuigtype().getTypenaam()%></td>
                <td><%=vliegtuig.getLuchtvaartmaatschappij().getLuchtvaartnaam()%></td>
                <td>
                    <a href ="AdminServlet?vliegtuigAanpassen=<%=vliegtuig.getId()%>">
                        <input type="submit" name="vliegtuigAanpassen" value="Aanpassen">
                    </a>
                </td>
                <td>
                    <a href ="AdminServlet?vliegtuigVerwijderen=<%=vliegtuig.getId()%>">
                        <input type="submit" name="vliegtuigVerwijderen" value="Verwijderen">
                    </a>
                </td>
            </tr>

            <% }%>

        </table>




    </body>
</html>
