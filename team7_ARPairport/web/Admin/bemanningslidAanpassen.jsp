<%-- 
    Document   : bemanningslidAanpassen
    Created on : 16-mei-2018, 10:37:42
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="hbo5.it.www.beans.Functie"%>
<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bemanningslid Aanpassen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>

        <div class="maincontainer">

            <h2>Bemanningslid Aanpassen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <%
                        Bemanningslid bemanningslid = (Bemanningslid) request.getAttribute("bemanningslid");
                        
                        ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("luchtvaartmaatschappijen");
                        ArrayList<Functie> functies = (ArrayList<Functie>) request.getAttribute("functies");
                        ArrayList<Persoon> personen = (ArrayList<Persoon>) request.getAttribute("personen");
                    %>

                    <input type="hidden" name="bemanningslidid" value="<%=bemanningslid.getId()%>">

                    <p>
                        <label for="selectLuchtvaartmaatschappij">Luchtvaartmaatschappij: </label>

                        <select name="selectLuchtvaartmaatschappij">
                            <% for (Luchtvaartmaatschappij luchtvaartmaatschappij : luchtvaartmaatschappijen) {%>
                            <option name="selectLuchtvaartmaatschappij" value="<%=luchtvaartmaatschappij.getId()%>"><%=luchtvaartmaatschappij.getLuchtvaartnaam()%></option>
                            <% }%>
                        </select>
                    </p>

                    <p>
                        <label for="selectFunctie">Functie: </label>

                        <select name="selectFunctie">
                            <% for (Functie functie : functies) {%>
                            <option name="selectFunctie" value="<%=functie.getId()%>"><%=functie.getFunctienaam()%></option>
                            <% }%>
                        </select>
                    </p>

                    <p>
                        <label for="selectPersoon">Functie: </label>

                        <select name="selectPersoon">
                            <% for (Persoon persoon : personen) {%>
                            <option name="selectPersoon" value="<%=persoon.getId()%>"><%=persoon.getVoornaam()%> <%=persoon.getFamilienaam()%></option>
                            <% }%>
                        </select>
                    </p>

                    <input type="submit" value="Aanpassen" name="bemanningslidAanpassen" />

                </div>
            </form>            
        </div>                     

    </body>
</html>
