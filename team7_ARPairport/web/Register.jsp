<%-- 
    Document   : Register
    Created on : May 2, 2018, 9:09:47 AM
    Author     : 3230059
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form action="InlogServlet" method="GET">
                    <p>
                        <label>Voornaam:</label>
                        <input type="text" name="FirstName"/>
                        <label>Achternaam:</label>
                        <input type="text" name="Surname"/>
                    </p>
                    <p>
                        <label>Straat:</label>
                        <input type="text" name="Street"/>
                        <label>Huisnummer:</label>
                        <input type="text" name="Number"/>
                    </p>
                    <p>
                        <label>Postcode:</label>
                        <input type="text" name="PostalCode"/>
                    </p>
                    <p>
                        <label>Woonplaats:</label>
                        <input type="text" name="Place"/>
                    </p>
                    <p>
                        <label>Land:</label>
                        <input type="text" name="Country"/>
                    </p>
                    <p>
                        <label>Geboortedatum:</label>
                        <input type="date" name="DateOfBirth"/>
                    </p>
                    <p>
                        <label>Login:</label>
                        <input type="text" name="Login"/>
                    </p>
                    <p>
                        <label>Passwoord:</label>
                        <input type="text" name="Password"/>
                    </p>
                    <p>
                        <button name="confirm" class="button"><span>Registreren</span></button> 
                        <label name="lblResult"/>
                    </p>
                </form>
    </body>
</html>
