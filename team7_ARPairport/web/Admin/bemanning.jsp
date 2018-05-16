<%-- 
    Document   : bemanning
    Created on : 8-mei-2018, 14:49:19
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bemanning Beheren</title>

        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">

        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:1200px;
                margin: 0 auto;
            }
        </style>    

        <%
            ArrayList<Bemanningslid> bemanningsleden = (ArrayList<Bemanningslid>) request.getAttribute("bemanningsleden");
        %>     

    </head>
    <body>
        <h1>Bemanning Beheren</h1>        

        <form action="AdminServlet">
            <input type="submit" value="Bemanningslid Toevoegen" name="bemanningslidToevoegen" />
        </form>

        <table class="redTable">

            <tr>
                <th>Voornaam</th>
                <th>Familienaam</th>
                <th>Luchtvaartmaatschappij</th>
                <th>Functie</th>
                <th>Omschrijving</th>
                <th></th>
                <th></th>
            </tr>

            <% for (Bemanningslid bemanningslid : bemanningsleden) {%>

            <tr>
                <td><%=bemanningslid.getPersoon().getVoornaam()%></td>
                <td><%=bemanningslid.getPersoon().getFamilienaam()%></td>
                <td><%=bemanningslid.getLuchtvaartmaatschappij().getLuchtvaartnaam()%></td>
                <td><%=bemanningslid.getFunctie().getFunctienaam()%></td>
                <td><%=bemanningslid.getFunctie().getOmschrijving()%></td>

                <td>
                    <a href ="AdminServlet?bemanningslidAanpassen=<%=bemanningslid.getId()%>">
                        <input type="submit" name="bemanningslidAanpassen" value="Aanpassen">
                    </a>
                </td>
                <td>
                    <a href ="AdminServlet?bemanningslidVerwijderen=<%=bemanningslid.getId()%>">
                        <input type="submit" name="bemanningslidVerwijderen" value="Verwijderen">
                    </a>
                </td>
            </tr>

            <% }%>

        </table>


    </body>
</html>
