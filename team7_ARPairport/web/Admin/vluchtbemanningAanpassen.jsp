<%-- 
    Document   : vluchtbemanningAanpassen
    Created on : 22-mei-2018, 13:20:27
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vluchtbemanning"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vluchtbemanning Aanpassen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">
            <h2>Vluchtbemanning Aanpassen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <%
                        Vluchtbemanning vluchtbemanning = (Vluchtbemanning) request.getAttribute("vluchtbemanning");
                        ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) request.getAttribute("vluchten");
                        ArrayList<Bemanningslid> bemanningsleden = (ArrayList<Bemanningslid>) request.getAttribute("bemanningsleden");
                    %>

                    <input type="hidden" name="vluchtbemanningid" value="<%=vluchtbemanning.getId()%>">

                    <p>
                        <label for="taak">Taak: </label>
                        <input type="text" id="taak" name="taak" value="<%=vluchtbemanning.getTaak()%>"></input>
                    </p>  


                    <p>
                        <label for="selectBemanningslid">Bemanningslid: </label>

                        <select name="selectBemanningslid">
                            <% for (Bemanningslid bemanningslid : bemanningsleden) {%>
                            <option name="selectBemanningslid" value="<%=bemanningslid.getId()%>"><%=bemanningslid.getPersoon().getVoornaam()%> <%=bemanningslid.getPersoon().getFamilienaam()%></option>
                            <% }%>    
                        </select>
                    </p>  


                    <p>
                        <label for="selectVlucht">Vlucht: </label>

                        <select name="selectVlucht">
                            <% for (Vlucht vlucht : vluchten) {%>
                            <option name="selectVlucht" value="<%=vlucht.getId()%>"><%=vlucht.getCode()%>: <%=vlucht.getVertrekluchthaven().getLuchthavennaam()%> - <%=vlucht.getAankomstluchthaven().getLuchthavennaam()%></option>
                            <% }%>    
                        </select>
                    </p>  


                    <input type="submit" value="Aanpassen" name="vluchtbemanningAanpassen" />

                </div>                              
            </form>

            <p><a href="#" onclick="history.go(-1)">Terug</a></p>

        </div>
    </body>
</html>
