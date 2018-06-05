<%-- 
    Document   : passagiersPerKlasse
    Created on : 30-mei-2018, 8:44:59
    Author     : roel_
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passagiers Per Klasse</title>

        <%
            Vlucht vlucht = (Vlucht) request.getAttribute("vlucht");
            Map<String, Integer> passagiersPerKlasse = (HashMap< String, Integer>) request.getAttribute("passagiersPerKlasse");
        %>

        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">

        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:800px;
                margin: 0 auto;
            }
        </style>     

    </head>
    <body>

        <h3>Passagier Statistieken voor vlucht:</h3>
        <h5><%=vlucht.getCode()%>: <%=vlucht.getVertrekluchthaven().getLuchthavennaam()%> - <%=vlucht.getAankomstluchthaven().getLuchthavennaam()%></h5>

        <table class="redTable">
            <tr>
                <th>Klasse</th>
                <th>Aantal Passagiers</th>
            </tr>
            <% for (Map.Entry<String, Integer> entry : passagiersPerKlasse.entrySet()) {%>
            <tr>                
                <td><%=entry.getKey()%></td>
                <td><%=entry.getValue()%></td>                
            </tr>            
            <% }%>
        </table>

        <p><a href="#" onclick="history.go(-1)">Terug</a></p>

    </body>
</html>
