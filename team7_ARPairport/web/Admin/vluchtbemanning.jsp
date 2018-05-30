<%-- 
    Document   : vluchtbemanning
    Created on : 8-mei-2018, 14:49:49
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Vluchtbemanning"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vluchtbemanning Beheren</title>

        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">

        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:800px;
                margin: 0 auto;
            }
        </style>

        <% ArrayList<Vluchtbemanning> vluchtbemanningen = (ArrayList<Vluchtbemanning>) request.getAttribute("vluchtbemanningen");%>   

    </head>
    <body>
        <h1>Vluchtbemanning Beheren</h1>

        <form action="AdminServlet">
            <input type="submit" value="Vluchtbemanning Toevoegen" name="vluchtbemanningToevoegen" />
        </form>

        <table class="redTable">
            <tr>
                <th>Taak</th>
                <th>Vlucht</th>
                <th>Bemanningslid</th>
                <th></th>
                <th></th>
            </tr>

            <% for (Vluchtbemanning vluchtbemanning : vluchtbemanningen) {%>

            <tr>
                <td><%=vluchtbemanning.getTaak()%></td>
                <td><%=vluchtbemanning.getVlucht().getCode()%></td>
                <td><%=vluchtbemanning.getBemanningslid().getPersoon().getVoornaam()%> <%=vluchtbemanning.getBemanningslid().getPersoon().getFamilienaam()%></td>

                <td>
                    <a href ="AdminServlet?vluchtbemanningAanpassen=<%=vluchtbemanning.getId()%>">
                        <input type="submit" name="vluchtbemanningAanpassen" value="Aanpassen">
                    </a>
                </td>
                <td>
                    <a href ="AdminServlet?vluchtbemanningVerwijderen=<%=vluchtbemanning.getId()%>">
                        <input type="submit" name="vluchtbemanningVerwijderen" value="Verwijderen">
                    </a>
                </td>
            </tr>

            <% }%>

        </table>

        <p><a href="admin.jsp">Terug</a></p>

    </body>
</html>
