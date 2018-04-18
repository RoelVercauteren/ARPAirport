<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
    <style>
 /* Split the screen in half */
.split {
  height: 100%;
  width: 50%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
}

body {
    font-family: "Lucida Console", Monaco, monospace;
}

.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
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
  background-color: whitesmoke;
}

/* Control the right side */
.right {
  right: 0;
  background-color: lightgrey;
}

/* If you want the content centered horizontally and vertically */
.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
}

/* Style the image inside the centered container, if needed */
.centered img {
  width: 150px;
  border-radius: 50%;
} 
    </style>
        <title>Welcome</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="split left">
            <div class="centered">
                <p>Ik ben klant en wil informatie opzoeken voor vluchten.</p>
                <button class="button" style="vertical-align:middle"><span>Vluchten zoeken!</span></button>
            </div>
        </div>
        <div class="split right">
            <div class="centered">
                <p>Ik ben werknemer en wil mezelf aanmelden</p>
                <button class="button" style="vertical-align:middle"><span>Aanmelden!</span></button>
            </div>
        </div>
    </body>
</html>
