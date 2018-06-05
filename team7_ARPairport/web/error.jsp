<%-- 
    Document   : error
    Created on : 16-mei-2018, 10:54:36
    Author     : roel_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error!</title>
        <style>
            body {
                font-family: "Lucida Console", Monaco, monospace;
                background-color: lightblue;
                width:1200px;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <h1>Oeps!</h1>

        <% String fout = (String) request.getAttribute("fout");%>

        <p>
            <%=fout%>
        </p>

        <p><a href="#" onclick="history.go(-1)">Terug</a></p>

    </body>
</html>
