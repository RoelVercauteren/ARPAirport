<%-- 
    Document   : passagierlijst
    Created on : May 16, 2018, 11:12:13 AM
    Author     : 3230059
--%>

<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="hbo5.it.www.beans.Passagier"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

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
        <% ArrayList<Passagier> passagiers = (ArrayList<Passagier>) request.getAttribute("passagiers");%>
        <h1>Passagierlijst vlucht <%=passagiers.get(0).getVlucht().getCode()%></h1>
        <table class="redTable">
            <th>Naam</th>
            <th>Ingecheckt</th>
            <th>Klasse</th>
            <th>Land</th>
            <th>Geboortedatum</th>
        <tbody>
            <%for (int i = 0; i < 10; i++) {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(passagiers.get(i).getPersoon().getFamilienaam() + " " + passagiers.get(i).getPersoon().getVoornaam());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(passagiers.get(i).getIngecheckt());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(passagiers.get(i).getVliegtuigklasse().getKlassenaam());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(passagiers.get(i).getPersoon().getLand());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(passagiers.get(i).getPersoon().getGeboortedatum());
                }%>
        </tbody>
    </table>

    <p><a href="#" onclick="history.go(-1)">Terug</a></p>

</body>
</html>
