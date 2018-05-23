<%-- 
    Document   : luchtvaartmaatschappijAanpassen
    Created on : 15-mei-2018, 13:24:44
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Luchtvaartmaatschappij Aanpassen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">
            <h2>Luchtvaartmaatschappij Aanpassen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <%
                        Luchtvaartmaatschappij luchtvaartmaatschappij = (Luchtvaartmaatschappij) request.getAttribute("luchtvaartmaatschappij");
                    %>

                      <input type="hidden" name="luchtvaartmaatschappijid" value="<%=luchtvaartmaatschappij.getId()%>">
                    
                    <p>
                        <label for="naam">Naam: </label>
                        <input type="text" id="naam" name="naam" value="<%=luchtvaartmaatschappij.getLuchtvaartnaam()%>"></input>
                    </p>  

                    <input type="submit" value="Aanpassen" name="luchtvaartmaatschappijAanpassen" />

                </div>                              
            </form>
        </div>
    </body>
</html>
