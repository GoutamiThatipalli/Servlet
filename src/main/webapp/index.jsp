<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            fieldset {
             width: 40%;
             border: 2px solid red;
             border-radius: 20px;
            }
        </style>
    </head>
    <body>
        <center>
        <h1>Hey there Please Login!</h1><br/><br/><br/><br/>
        <form action="Login" method="post">
        <fieldset>
        <legend align="center">Login Form</legend><br/>
        <input type="text" name="userid" placeholder="Type your Name" required="required"><br/><br/>
        <input type="password" name="password" placeholder="Type your Password" required="required"><br/><br/>
	<input type="Submit" value="Login"><br/><br>
	<button type="button" onclick="window.location='Register.html'">SignUp</button>
        <button type="button" >Forgot Pass?</button>
        </fieldset>
        </form>
    </body>
</html>
