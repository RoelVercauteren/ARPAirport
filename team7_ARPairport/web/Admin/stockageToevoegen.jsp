<%-- 
    Document   : stockageToevoegen
    Created on : 23-mei-2018, 9:18:29
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Hangar"%>
<%@page import="hbo5.it.www.beans.Vliegtuig"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stockage Toevoegen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>

        <div class="maincontainer">

            <h2>Stockage Toevoegen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <p>
                        <label for="reden">Reden: </label>
                        <input type="text" id="reden" name="reden"></input>
                    </p>   


                    <p>
                        <label for="vandatum">Vanaf: </label>
                        <input type="date" id="vandatum" name="vandatum" value="2017-06-01"></input>
                    </p> 

                    <p>
                        <label for="totdatum">Tot: </label>
                        <input type="date" id="totdatum" name="totdatum" value="2017-06-01"></input>
                    </p> 

                    <p>
                        <label for="selectVliegtuig">Vliegtuig: </label>

                        <% ArrayList<Vliegtuig> vliegtuigen = (ArrayList<Vliegtuig>) request.getAttribute("vliegtuigen"); %>

                        <select name="selectVliegtuig">
                            <% for (Vliegtuig vliegtuig : vliegtuigen) {%>
                            <option name="selectVliegtuig" value="<%=vliegtuig.getId()%>"><%=vliegtuig.getVliegtuigtype().getTypenaam()%> - <%=vliegtuig.getLuchtvaartmaatschappij().getLuchtvaartnaam()%></option>
                            <% }%>    
                        </select>
                    </p>  

                    <p>
                        <label for="selectHangar">Vliegtuig: </label>

                        <% ArrayList<Hangar> hangars = (ArrayList<Hangar>) request.getAttribute("hangars"); %>

                        <select name="selectHangar">
                            <% for (Hangar hangar : hangars) {%>
                            <option name="selectHangar" value="<%=hangar.getId()%>"><%=hangar.getHangarnaam()%></option>
                            <% }%>    
                        </select>
                    </p>  

                    <input type="submit" value="Toevoegen" name="stockageToevoegen" />

                </div>
            </form>
        </div>

    </body>
</html>
