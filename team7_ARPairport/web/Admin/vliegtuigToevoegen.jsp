<%-- 
    Document   : vliegtuigToevoegen
    Created on : 15-mei-2018, 14:38:23
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="hbo5.it.www.beans.Vliegtuigtype"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vliegtuig Toevoegen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">

            <h2>Vliegtuig Toevoegen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <p>
                        <label for="selectVliegtuigtype">Vliegtuigtype: </label>

                        <% ArrayList<Vliegtuigtype> vliegtuigtypes = (ArrayList<Vliegtuigtype>) request.getAttribute("vliegtuigtypes"); %>

                        <select name="selectVliegtuigtype">
                            <% for (Vliegtuigtype vliegtuigtype : vliegtuigtypes) {%>
                            <option name="selectVliegtuigtype" value="<%=vliegtuigtype.getId()%>"><%=vliegtuigtype.getTypenaam()%></option>
                            <% }%>    
                        </select>
                    </p>  

                    <p>
                        <label for="selectLuchtvaartmaatschappij">Luchtvaartmaatschappij: </label>

                        <% ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("luchtvaartmaatschappijen");%>

                        <select name="selectLuchtvaartmaatschappij">
                            <% for (Luchtvaartmaatschappij luchtvaartmaatschappij : luchtvaartmaatschappijen) {%>
                            <option name="selectLuchtvaartmaatschappij" value="<%=luchtvaartmaatschappij.getId()%>"><%=luchtvaartmaatschappij.getLuchtvaartnaam()%></option>
                            <% }%>
                        </select>
                    </p>

                    <input type="submit" value="Toevoegen" name="vliegtuigToevoegen" />

                </div>
            </form>
        </div>
    </body>
</html>
