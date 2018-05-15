<%-- 
    Document   : luchthavenAanpassen
    Created on : 9-mei-2018, 10:32:03
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Land"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Luchthaven Aanpassen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">
            <h2>Luchthaven Aanpassen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <%
                        Luchthaven luchthaven = (Luchthaven) request.getAttribute("luchthaven");
                        ArrayList<Land> landen = (ArrayList<Land>) request.getAttribute("landen");
                    %>

                    <input type="hidden" name="luchthavenid" value="<%=luchthaven.getId()%>">

                    <p>
                        <label for="naam">Naam: </label>
                        <input type="text" id="naam" name="naam" value="<%=luchthaven.getLuchthavennaam()%>"></input>
                    </p>  
                    <p>
                        <label for="stad">Stad: </label>
                        <input type="text" id="stad" name="stad" value="<%=luchthaven.getStad()%>"></input>
                    </p>  
                    <p>
                        <label for="selectLand">Land: </label>

                        <select name="selectLand">
                            <% for (Land land : landen) {%>
                            <option name="selectLand" value="<%=land.getId()%>"><%=land.getLandnaam()%></option>
                            <% }%>    
                        </select>
                    </p>  

                    <input type="submit" value="Aanpassen" name="luchthavenAanpassen" />

                </div>                
            </form>

        </div>
    </body>
</html>
