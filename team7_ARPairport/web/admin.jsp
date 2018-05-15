<%-- 
    Document   : admin
    Created on : 8-mei-2018, 14:26:38
    Author     : roel_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>

        <link rel="stylesheet" type="text/css" href="css/formstyle.css">


    </head>
    <body>
        <div class="maincontainer">
            <h2>Welkom Admin</h2>

            <form action="AdminServlet">
                <div class="divinform">
                    <h2>Selecteer een optie:</h2>

                    <input type="submit" value="Beheren luchthavens" name="knopLuchthaven"/>
                    <input type="submit" value="Beheren luchtvaartmaatschappijen" name="knopLuchtvaartmaatschappijen"/>
                    <input type="submit" value="Beheren vliegtuigen" name="knopVliegtuigen"/>
                    <input type="submit" value="Beheren hangars" name="knopHangars"/>
                    <input type="submit" value="Beheren bemanning" name="knopBemanning"/>
                    <input type="submit" value="Beheren vluchtbemanning" name="knopVluchtbemanning"/>
                    <input type="submit" value="Beheren vliegtuigen in hangars" name="knopVliegtuigenInHangars"/>

                </div>
            </form>
        </div>
    </body>
</html>
