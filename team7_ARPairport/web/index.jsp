<%-- 
    Document   : welcome
    Created on : Apr 18, 2018, 9:45:49 AM
    Author     : 3230059
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <style>
            body {
                background-color: lightblue;
                font-family: "Lucida Console", Monaco, monospace;
            }
            img {
                display: block;
                margin: auto;
                width: 35%;
            }

            .header {
                border-bottom: 3px black dashed;
                width: 80%;
                margin: auto;
            }

            .team {
                display: block;
                margin: auto;
                width: 30%;
                text-align: center;
            }
            .split {
                height: 30%;
                width: 50%;
                position: absolute;
                margin-top: 45%;
                z-index: 1;
                top: 0;
                overflow-x: hidden;
                padding-top: 5px;
            }

            .button {
                display: inline-block;
                border-radius: 4px;
                background-color: #f4511e;
                border: none;
                color: #FFFFFF;
                text-align: center;
                font-size: 14px;
                padding: 8px;
                width: 80%; /*200px*/
                transition: all 0.5s;
                cursor: pointer;
                margin: 5px;
            }

            .button span {
                cursor: pointer;
                display: inline-block;
                position: relative;
                transition: 0.5s;
            }

            .button span:after {
                content: '\00bb';
                position: absolute;
                opacity: 0;
                top: 0;
                right: -20px;
                transition: 0.5s;
            }

            .button:hover span {
                padding-right: 25px;
            }

            .button:hover span:after {
                opacity: 1;
                right: 0;
            }

            /* Control the left side */
            .left {
                left: 0;
                background-color: lightblue;
            }

            /* Control the right side */
            .right {
                right: 0;
                background-color: lightblue;
            }

            /* If you want the content centered horizontally and vertically */
            .centered {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="header">
            <img src="${pageContext.request.contextPath}/Images/Header.png"/>
            <div class="team">
                <h1>Team 7</h1>
                <p>Roel Vercauteren</p>
                <p>Andrei Shepel</p>
                <p>Gert Scheers</p>
            </div>
        </div>
        <div class="split left">
            <div class="centered">
                <p>Ik ben klant en wil informatie opzoeken voor vluchten.</p>
                <form action="ZoekServlet"><button class="button" style="vertical-align:middle" value="zoekKnop"><span>Vluchten zoeken!</span></button></form>
            </div>
        </div>
        <div class="split right">
            <div class="centered">
                <form action="InlogServlet" method="GET">
                    <p>
                        <label>Username: </label>
                        <input type="text" name="Username"/>
                    </p>
                    <p>
                        <label>Password: </label>
                        <input type="password" name="Password"/>
                        <% if((String)request.getAttribute("fout") != null) { %>
                    <p><%session.getAttribute("fout");%></p>
                    <%}%>
                    </p>
                    <p>
                        <button class="button" type="submit" style="vertical-align:middle"><span>Aanmelden!</span></button>
                        <button class="button" style="vertical-align:middle"><span>Registreren!</span></button>
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>