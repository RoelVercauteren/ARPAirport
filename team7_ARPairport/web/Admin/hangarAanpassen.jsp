<%-- 
    Document   : hangarAanpassen
    Created on : 16-mei-2018, 8:57:46
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Hangar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hangar Aanpassen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">
            <h2>Hangar Aanpassen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <%
                        Hangar hangar = (Hangar) request.getAttribute("hangar");
                    %>

                    <input type="hidden" name="hangarid" value="<%=hangar.getId()%>">

                    <p>
                        <label for="naam">Naam: </label>
                        <input type="text" id="naam" name="naam" value="<%=hangar.getHangarnaam()%>"></input>
                    </p>  

                    <input type="submit" value="Aanpassen" name="hangarAanpassen" />

                </div>                              
            </form>

            <p><a href="#" onclick="history.go(-1)">Terug</a></p>

        </div>
    </body>
</html>
