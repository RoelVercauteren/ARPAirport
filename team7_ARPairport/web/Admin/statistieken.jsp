<%-- 
    Document   : statistieken
    Created on : 23-mei-2018, 10:40:05
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistieken Opvragen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

        <%
            ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("luchtvaartmaatschappijen");
            ArrayList<Luchthaven> luchthavens = (ArrayList<Luchthaven>) request.getAttribute("luchthavens");
        %>


    </head>
    <body>
        <div class="maincontainer">
            <h2>Welkom Admin</h2>

            <form action="AdminServlet">
                <div class="divinform">
                    <h3>Aantal Passagiers:</h3>

                    <p>
                        <label for="selectLuchtvaartmaatschappij">Luchtvaartmaatschappij: </label>

                        <select name="selectLuchtvaartmaatschappij">
                            <% for (Luchtvaartmaatschappij luchtvaartmaatschappij : luchtvaartmaatschappijen) {%>
                            <option name="selectLuchtvaartmaatschappij" value="<%=luchtvaartmaatschappij.getId()%>"><%=luchtvaartmaatschappij.getLuchtvaartnaam()%></option>
                            <% }%>    
                        </select>
                    </p>  
                    <input type="submit" value="Per Luchtvaartmaatschappij" name="knopStatistiekenLuchtvaartmaatschappij"/>

                    <p>
                        <label for="selectLuchthaven">Luchthaven: </label>

                        <select name="selectLuchthaven">
                            <% for (Luchthaven luchthaven : luchthavens) {%>
                            <option name="selectLuchthaven" value="<%=luchthaven.getId()%>"><%=luchthaven.getLuchthavennaam()%></option>
                            <% }%>    
                        </select>
                    </p>  
                    <input type="submit" value="Per Luchthaven" name="knopStatistiekenLuchthaven"/>

                    <hr />

                    <h3>Gemiddelde leeftijd per bestemming: </h3>

                    <p>
                        <label for="selectBestemming">Bestemming: </label>

                        <select name="selectBestemming">
                            <% for (Luchthaven luchthaven : luchthavens) {%>
                            <option name="selectBestemming" value="<%=luchthaven.getId()%>"><%=luchthaven.getLuchthavennaam()%></option>
                            <% }%>    
                        </select>
                    </p>  
                    <input type="submit" value="Gemiddelde Leeftijd" name="knopStatistiekenLeeftijd"/>


                </div>
            </form>
        </div>
    </body>
</html>
