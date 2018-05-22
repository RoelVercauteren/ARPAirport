<%-- 
    Document   : hangarToevoegen
    Created on : 16-mei-2018, 8:48:36
    Author     : roel_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hangar Toevoegen</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">

    </head>
    <body>

        <div class="maincontainer">

            <h2>Hangar Toevoegen</h2>

            <form action="AdminServlet">
                <div class="divinform">        

                    <p>
                        <label for="naam">Naam: </label>
                        <input type="text" id="naam" name="naam"></input>
                    </p>                

                    <input type="submit" value="Toevoegen" name="hangarToevoegen" />

                </div>
            </form>

        </div>

    </body>
</html>
