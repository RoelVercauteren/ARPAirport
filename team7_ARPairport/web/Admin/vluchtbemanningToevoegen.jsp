<%-- 
    Document   : vluchtbemanningToevoegen
    Created on : 16-mei-2018, 11:37:49
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vluchtbemanning Toevoegen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">

            <h2>Vluchtbemanning Toevoegen</h2>

            <form action="AdminServlet">
                <div class="divinform">

                    <p>
                        <label for="taak">Taak: </label>
                        <input type="text" id="taak" name="taak"></input>
                    </p>    

                    <p>
                        <label for="selectBemanningslid">Bemanningslid: </label>

                        <% ArrayList<Bemanningslid> bemanningsleden = (ArrayList<Bemanningslid>) request.getAttribute("bemanningsleden"); %>

                        <select name="selectBemanningslid">
                            <% for (Bemanningslid bemanningslid : bemanningsleden) {%>
                            <option name="selectBemanningslid" value="<%=bemanningslid.getId()%>"><%=bemanningslid.getFunctie().getFunctienaam()%> -  <%=bemanningslid.getPersoon().getVoornaam()%> <%=bemanningslid.getPersoon().getFamilienaam()%></option>
                            <% }%>    
                        </select>
                    </p>  

                    <%-- 
                    todo: selectVlucht
                    --%>

                    <input type="submit" value="Toevoegen" name="vluchtbemanningToevoegen" />

                </div>
            </form>
        </div>

    </body>
</html>
