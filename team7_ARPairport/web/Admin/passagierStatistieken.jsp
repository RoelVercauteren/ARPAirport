<%-- 
    Document   : passagierStatistieken
    Created on : 29-mei-2018, 13:29:11
    Author     : roel_
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aantal Passagiers</title>

        <%
            String passagiersvoor = (String) request.getAttribute("passagiersvoor");

            Map<String, Integer> passagiersPerDag = (HashMap<String, Integer>) request.getAttribute("passagiersPerDag");
            Map<String, Integer> passagiersPerMaand = (HashMap<String, Integer>) request.getAttribute("passagiersPerMaand");
            Map<String, Integer> passagiersPerVlucht = (HashMap<String, Integer>) request.getAttribute("passagiersPerVlucht");
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
        <h2>Passagier Statistieken voor <%=passagiersvoor%></h2>

        <h3>Per Vlucht</h3>
        <table class="redTable">
            <tr>
                <th>Vlucht</th>
                <th>Aantal Passagiers</th>
            </tr>
            <% for (Map.Entry<String, Integer> entry : passagiersPerVlucht.entrySet()) {%>
            <tr>                
                <td><%=entry.getKey()%></td>
                <td><%=entry.getValue()%></td>                
            </tr>            
            <% }%>
        </table>

        <h3>Per Dag</h3>
        <table class="redTable">
            <tr>
                <th>Dag</th>
                <th>Aantal Passagiers</th>
            </tr>
            <% for (Map.Entry<String, Integer> entry : passagiersPerDag.entrySet()) {%>
            <tr>                
                <td><%=entry.getKey()%></td>
                <td><%=entry.getValue()%></td>                
            </tr>            
            <% }%>
        </table>

        <h3>Per Maand</h3>
        <table class="redTable">
            <tr>
                <th>Maand</th>
                <th>Aantal Passagiers</th>
            </tr>
            <% for (Map.Entry<String, Integer> entry : passagiersPerMaand.entrySet()) {%>
            <tr>                
                <td><%=entry.getKey()%></td>
                <td><%=entry.getValue()%></td>                
            </tr>            
            <% }%>
        </table>

        <p><a href="AdminServlet?knopStatistiekenOpvragen">Terug</a></p>

    </body>
</html>
