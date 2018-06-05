<%-- 
    Document   : stockageAanpassen
    Created on : 23-mei-2018, 9:47:59
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Hangar"%>
<%@page import="hbo5.it.www.beans.Vliegtuig"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Stockage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stockage Aanpassen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">

            <h2>Stockage Aanpassen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <%
                        Stockage stockage = (Stockage) request.getAttribute("stockage");
                        ArrayList<Vliegtuig> vliegtuigen = (ArrayList<Vliegtuig>) request.getAttribute("vliegtuigen");
                        ArrayList<Hangar> hangars = (ArrayList<Hangar>) request.getAttribute("hangars");
                    %>

                    <input type="hidden" name="stockageid" value="<%=stockage.getId()%>">

                    <p>
                        <label for="reden">Reden: </label>
                        <input type="text" id="reden" name="reden" value="<%=stockage.getReden()%>"></input>
                    </p>   


                    <p>
                        <label for="vandatum">Vanaf: </label>
                        <input type="date" id="vandatum" name="vandatum" value="<%=stockage.getVandatum()%>"></input>
                    </p> 

                    <p>
                        <label for="totdatum">Tot: </label>
                        <input type="date" id="totdatum" name="totdatum" value="<%=stockage.getTotdatum()%>"></input>
                    </p> 

                    <p>
                        <label for="selectVliegtuig">Vliegtuig: </label>

                        <select name="selectVliegtuig">
                            <% for (Vliegtuig vliegtuig : vliegtuigen) {%>
                            <option name="selectVliegtuig" value="<%=vliegtuig.getId()%>"><%=vliegtuig.getVliegtuigtype().getTypenaam()%> - <%=vliegtuig.getLuchtvaartmaatschappij().getLuchtvaartnaam()%></option>
                            <% }%>    
                        </select>
                    </p>  

                    <p>
                        <label for="selectHangar">Vliegtuig: </label>

                        <select name="selectHangar">
                            <% for (Hangar hangar : hangars) {%>
                            <option name="selectHangar" value="<%=hangar.getId()%>"><%=hangar.getHangarnaam()%></option>
                            <% }%>    
                        </select>
                    </p>  

                    <input type="submit" value="Aanpassen" name="stockageAanpassen" />

                </div>
            </form>            
                        
            <p><a href="#" onclick="history.go(-1)">Terug</a></p>
            
        </div>
    </body>
</html>
