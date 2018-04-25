<%-- 
    Document   : vluchten
    Created on : 24-apr-2018, 15:09:58
    Author     : roel_
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overzicht vluchten</title>
    </head>
    <body>
        <h1>Vluchten</h1>

        <% ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) request.getAttribute("vluchten"); %>

        <table>
            <tr>
                <th>Code</th>
                <th>Vertrektijd</th>
            </tr>

            <% for (Vlucht vlucht : vluchten) {%>
            <tr><%=vlucht.getCode()%></tr>
            <tr><%=vlucht.getVertrektijd()%></tr>
            <% }%>
        </table>


    </body>
</html>
