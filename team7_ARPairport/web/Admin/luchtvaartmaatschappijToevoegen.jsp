<%-- 
    Document   : luchtvaartmaatschappijToevoegen
    Created on : 9-mei-2018, 11:38:18
    Author     : roel_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Luchtvaartmaatschappij Toevoegen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>
        <div class="maincontainer">

            <h2>Luchtvaartmaatschappij Toevoegen</h2>

            <form action="AdminServlet">
                <div class="divinform">        

                    <p>
                        <label for="naam">Naam: </label>
                        <input type="text" id="naam" name="naam"></input>
                    </p>                

                    <input type="submit" value="Toevoegen" name="luchtvaartmaatschappijToevoegen" />

                </div>
            </form>

            <p><a href="#" onclick="history.go(-1)">Terug</a></p>

        </div>
    </body>
</html>
