<%-- 
    Document   : luchthavenToevoegen
    Created on : 9-mei-2018, 9:11:17
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Land"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Luchthaven Toevoegen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">

            <h2>Luchthaven Toevoegen</h2>

            <form action="AdminServlet">
                <div class="divinform">
                    <p>
                        <label for="naam">Naam: </label>
                        <input type="text" id="naam" name="naam"></input>
                    </p>  
                    <p>
                        <label for="stad">Stad: </label>
                        <input type="text" id="stad" name="stad"></input>
                    </p>  
                    <p>
                        <label for="selectLand">Land: </label>

                        <% ArrayList<Land> landen = (ArrayList<Land>) request.getAttribute("landen"); %>

                        <select name="selectLand">
                            <% for (Land land : landen) {%>
                            <option name="selectLand" value="<%=land.getId()%>"><%=land.getLandnaam()%></option>
                            <% }%>    
                        </select>
                    </p>  

                    <input type="submit" value="Toevoegen" name="luchthavenToevoegen" />
                </div>
            </form>
        </div>
    </body>
</html>
