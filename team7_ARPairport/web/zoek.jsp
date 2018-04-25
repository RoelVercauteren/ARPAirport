<%-- 
    Document   : zoek
    Created on : 24-apr-2018, 13:33:32
    Author     : roel_
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zoeken</title>
    </head>
    <body>        
        <h1>Vluchten zoeken</h1>

        <% ArrayList<Luchthaven> luchthavens = (ArrayList<Luchthaven>) request.getAttribute("luchthavens");%>

        <form action="ZoekServlet">
            <select name="selectLuchthaven">
                <% for (Luchthaven luchthaven : luchthavens) {%>
                <option name="selectLuchthaven" value="<%=luchthaven.getId()%>"><%=luchthaven.getLuchthavennaam()%></option>
                <% }%>    
            </select>
            <input type="submit" value="Zoek binnenkomende vluchten" name="zoekBinnenkomendeVluchtenKnop"/>
            <input type="submit" value="Zoek vertrekkende vluchten" name="zoekVertrekkendeVluchtenKnop"/>
        </form>



    </body>
</html>
