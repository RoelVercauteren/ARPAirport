<%-- 
    Document   : stockage
    Created on : 22-mei-2018, 14:08:12
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Stockage"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vliegtuigen In Hangars Beheren</title>

        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">

        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:800px;
                margin: 0 auto;
            }
        </style>

        <% ArrayList<Stockage> stockages = (ArrayList<Stockage>) request.getAttribute("stockages");%>   

    </head>
    <body>
        <h1>Vliegtuigen In Hangars Beheren</h1>

        <form action="AdminServlet">
            <input type="submit" value="Stockage Toevoegen" name="stockageToevoegen" />
        </form>

        <table class="redTable">
            <tr>
                <th>Reden</th>
                <th>Van</th>
                <th>Tot</th>
                <th>Hangarnaam</th>
                <th>maatschappij</th>
                <th>Vliegtuigtype</th>
                <th></th>
                <th></th>
            </tr>

            <% for (Stockage stockage : stockages) {%>

            <tr>
                <td><%=stockage.getReden()%></td>
                <td><%=stockage.getVandatum()%></td>
                <td><%=stockage.getTotdatum()%></td>
                <td><%=stockage.getHangar().getHangarnaam()%></td>
                <td><%=stockage.getVliegtuig().getLuchtvaartmaatschappij().getLuchtvaartnaam()%></td>
                <td><%=stockage.getVliegtuig().getVliegtuigtype().getTypenaam()%></td>

                <td>
                    <a href ="AdminServlet?stockageAanpassen=<%=stockage.getId()%>">
                        <input type="submit" name="stockageAanpassen" value="Aanpassen">
                    </a>
                </td>
                <td>
                    <a href ="AdminServlet?stockageVerwijderen=<%=stockage.getId()%>">
                        <input type="submit" name="stockageVerwijderen" value="Verwijderen">
                    </a>
                </td>
            </tr>

            <% }%>

        </table>                        

    </body>
</html>
