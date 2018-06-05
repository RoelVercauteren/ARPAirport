<%-- 
    Document   : WelcomPassagier
    Created on : May 16, 2018, 8:53:41 AM
    Author     : andre
--%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passagier Page</title>
        <link rel="stylesheet" type="text/css" href="css/formstyle.css">
    </head>
    <body>
        <div class="maincontainer">
            <%
                Persoon persoon = (Persoon) session.getAttribute("currentSessionUser");
            %>
            <p>
            <h2>Welcome <%=persoon.getVoornaam()%></h2>
            <form acion="InlogServlet">
                <input type="submit" value="logout" name="btnLogout"></button>
            </form>
        </p>
        <form action="ManageServlet">
            <div class="divinform">
                <h2>Wat wil je bekijken?</h2>
                <input type="submit" value="Geboekte vluchten" name="knopGeboekte"/>
                <input type="submit" value="Alle vluchten" name="knopAlleVluchten"/>
            </div>
        </form>
    </div>
</body>
</html>
