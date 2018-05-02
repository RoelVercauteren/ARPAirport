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

        <div>

            <h3>Zoek on luchthaven</h3>

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
        </div>

        <div>      

            <h3>Zoek met filter</h3>

            <form action="ZoekServlet">
                <p>
                    <label for="vluchtcode">Vluchtnummer: </label>
                    <input type="text" id="vluchtcode" name="vluchtcode"></input>
                </p>  
                <p>
                    <label for="datum">Datum (yyyy-mm-dd): </label>
                    <input type="text" id="datum" name="datum" value="2017-06-01"></input>
                </p>  
                <p>
                    <label for="bestemming">Bestemming: </label>
                    <input type="text" id="bestemming" name="bestemming"></input>
                </p>  
                <p>
                    <label for="luchtvaartmaatschappij">Luchtvaartmaatschappij: </label>
                    <input type="text" id="luchtvaartmaatschappij" name="luchtvaartmaatschappij"></input>
                </p>  
                <p>
                    <input type="submit" value="Zoeken" name="zoekVluchtenMetFilter" />
                </p>
            </form>

            <a href="index.jsp">Terug</a>

        </div>


    </body>
</html>
