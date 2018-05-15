<%-- 
    Document   : luchthavens
    Created on : 8-mei-2018, 14:45:17
    Author     : roel_
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Luchthavens Beheren</title>

        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">

        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:800px;
                margin: 0 auto;
            }
        </style>       


        <% ArrayList<Luchthaven> luchthavens = (ArrayList<Luchthaven>) request.getAttribute("luchthavens");%>        
    </head>
    <body>
        <h1>Luchthavens Beheren</h1>

        <form action="AdminServlet">
            <input type="submit" value="Luchthaven Toevoegen" name="luchthavenToevoegen" />
        </form>

        <table class="redTable">
            <tr>
                <th>Naam</th>
                <th>Stad</th>
                <th>Land</th>
                <th></th>
            </tr>

            <% for (Luchthaven luchthaven : luchthavens) {%>

            <tr>
                <td><%=luchthaven.getLuchthavennaam()%></td>
                <td><%=luchthaven.getStad()%></td>
                <td><%=luchthaven.getLand().getLandnaam()%></td>
                <td>
                    <%--   <form action="AdminServlet">
                               <input type="hidden" name="luchthavenid" value="<%=luchthaven.getId()%>" /> 
                           <input type="submit" value="Aanpassen" name="luchthavenAanpassen" id="<%=luchthaven.getId()%>"/>
                       </form>
                    --%>
                    <a href ="AdminServlet?luchthavenAanpassen=<%=luchthaven.getId()%>">
                        <input type="submit" name="luchthavenAanpassen" value="Aanpassen">
                    </a>
                </td>
                <td>
                    <a href ="AdminServlet?luchthavenVerwijderen=<%=luchthaven.getId()%>">
                        <input type="submit" name="luchthavenVerwijderen" value="Verwijderen">
                    </a>
                </td>
            </tr>

            <% }%>

        </table>

    </body>
</html>
