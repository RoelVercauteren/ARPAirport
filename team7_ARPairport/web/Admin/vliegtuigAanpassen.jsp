<%-- 
    Document   : vliegtuigAanpassen
    Created on : 15-mei-2018, 15:13:57
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Vliegtuigtype"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vliegtuig"%>
<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vliegtuig Aanpassen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">

            <h2>Vliegtuig Aanpassen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <%
                        Vliegtuig vliegtuig = (Vliegtuig) request.getAttribute("vliegtuig");
                        ArrayList<Vliegtuigtype> vliegtuigtypes = (ArrayList<Vliegtuigtype>) request.getAttribute("vliegtuigtypes");
                        ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("luchtvaartmaatschappijen");
                    %>

                    <input type="hidden" name="vliegtuigid" value="<%=vliegtuig.getId()%>">

                    <p>
                        <label for="selectVliegtuigtype">Vliegtuigtype: </label>

                        <select name="selectVliegtuigtype">
                            <% for (Vliegtuigtype vliegtuigtype : vliegtuigtypes) {%>
                            <option name="selectVliegtuigtype" value="<%=vliegtuigtype.getId()%>"><%=vliegtuigtype.getTypenaam()%></option>
                            <% }%>    
                        </select>
                    </p>  

                    <p>
                        <label for="selectLuchtvaartmaatschappij">Luchtvaartmaatschappij: </label>

                        <select name="selectLuchtvaartmaatschappij">
                            <% for (Luchtvaartmaatschappij luchtvaartmaatschappij : luchtvaartmaatschappijen) {%>
                            <option name="selectLuchtvaartmaatschappij" value="<%=luchtvaartmaatschappij.getId()%>"><%=luchtvaartmaatschappij.getLuchtvaartnaam()%></option>
                            <% }%>
                        </select>
                    </p>

                    <input type="submit" value="Aanpassen" name="vliegtuigAanpassen" />

                </div>
            </form>       

            <p><a href="#" onclick="history.go(-1)">Terug</a></p>

        </div>                       
    </body>
</html>
