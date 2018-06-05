<%-- 
    Document   : bemanningslidToevoegen
    Created on : 16-mei-2018, 9:59:58
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="hbo5.it.www.beans.Functie"%>
<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bemanningslid Toevoegen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">

            <h2>Bemanningslid Toevoegen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <p>
                        <label for="selectLuchtvaartmaatschappij">Luchtvaartmaatschappij: </label>

                        <% ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("luchtvaartmaatschappijen");%>

                        <select name="selectLuchtvaartmaatschappij">
                            <% for (Luchtvaartmaatschappij luchtvaartmaatschappij : luchtvaartmaatschappijen) {%>
                            <option name="selectLuchtvaartmaatschappij" value="<%=luchtvaartmaatschappij.getId()%>"><%=luchtvaartmaatschappij.getLuchtvaartnaam()%></option>
                            <% }%>
                        </select>
                    </p>

                    <p>
                        <label for="selectFunctie">Functie: </label>

                        <% ArrayList<Functie> functies = (ArrayList<Functie>) request.getAttribute("functies");%>

                        <select name="selectFunctie">
                            <% for (Functie functie : functies) {%>
                            <option name="selectFunctie" value="<%=functie.getId()%>"><%=functie.getFunctienaam()%></option>
                            <% }%>
                        </select>
                    </p>

                    <p>
                        <label for="selectPersoon">Persoon: </label>

                        <% ArrayList<Persoon> personen = (ArrayList<Persoon>) request.getAttribute("personen");%>

                        <select name="selectPersoon">
                            <% for (Persoon persoon : personen) {%>
                            <option name="selectPersoon" value="<%=persoon.getId()%>"><%=persoon.getVoornaam()%> <%=persoon.getFamilienaam()%></option>
                            <% }%>
                        </select>
                    </p>


                    <input type="submit" value="Toevoegen" name="bemanningslidToevoegen" />

                </div>
            </form>      
                        
            <p><a href="#" onclick="history.go(-1)">Terug</a></p>

        </div>
    </body>
</html>
