<%-- 
    Document   : hangars
    Created on : 8-mei-2018, 14:48:31
    Author     : roel_
--%>

<%@page import="hbo5.it.www.beans.Hangar"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hangars Beheren</title>

        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">

        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:800px;
                margin: 0 auto;
            }
        </style>    

        <% ArrayList<Hangar> hangars = (ArrayList<Hangar>) request.getAttribute("hangars");%>        

    </head>
    <body>
        <h1>Hangars Beheren</h1>

        <form action="AdminServlet">
            <input type="submit" value="Hangar Toevoegen" name="hangarToevoegen" />
        </form>

        <table class="redTable">

            <% for (Hangar hangar : hangars) {%>

            <tr>
                <td><%=hangar.getHangarnaam()%></td>

                <td>
                    <a href ="AdminServlet?hangarAanpassen=<%=hangar.getId()%>">
                        <input type="submit" name="hangarAanpassen" value="Aanpassen">
                    </a>
                </td>
                <td>
                    <a href ="AdminServlet?hangarVerwijderen=<%=hangar.getId()%>">
                        <input type="submit" name="hangarVerwijderen" value="Verwijderen">
                    </a>
                </td>
            </tr>

            <% }%>

        </table>

        <p><a href="admin.jsp">Terug</a></p>

    </body>
</html>
