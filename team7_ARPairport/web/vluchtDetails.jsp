<%-- 
    Document   : vluchtDetails
    Created on : 2-mei-2018, 9:25:33
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details Vlucht</title>

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

        <h1>Details Vlucht</h1>

        <%
            Vlucht vlucht = (Vlucht) request.getAttribute("vlucht");
        %>

        <table class="redTable" style="width:600px;margin:0 auto;">            
            <tr>
                <td>Code</td>
                <td><%=vlucht.getCode()%></td>                
            </tr>                        
            <tr>
                <td>Vertrekplaats</td>
                <td><%=vlucht.getVertrekluchthaven().getLuchthavennaam()%> - <%=vlucht.getVertrekluchthaven().getStad()%></td>                
            </tr>                        
            <tr>
                <td>Vertrektijd</td>
                <td><%=vlucht.getVertrektijd().toLocaleString()%></td>                
            </tr>                        
            <tr>
                <td>Aankomstplaats</td>
                <td><%=vlucht.getAankomstluchthaven().getLuchthavennaam()%> - <%=vlucht.getAankomstluchthaven().getStad()%></td>                
            </tr>                        
            <tr>
                <td>Aankomsttijd</td>
                <td><%=vlucht.getAankomsttijd().toLocaleString()%></td>                
            </tr>                        
            <tr>
                <td>Luchtvaartmaatschappij</td>
                <td><%=vlucht.getVliegtuig().getLuchtvaartmaatschappij().getLuchtvaartnaam()%></td>                
            </tr>                      
            <tr>
                <td>Type Vliegtuig</td>
                <td><%=vlucht.getVliegtuig().getVliegtuigtype().getTypenaam()%></td>                
            </tr>  
            <tr>
                <td>Aantal passagiers</td>
                <td><%=request.getAttribute("aantalPassagiers")%></td>                
            </tr>  
            <tr>
                <td>Piloot</td>
                <td><%=request.getAttribute("piloot")%></td>                
            </tr>  
        </table>

        <p><a href="#" onclick="history.go(-1)">Terug</a></p>

    </body>
</html>
