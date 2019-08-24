<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<h2>Log in page</h2>
<br>
<form method="post" action="/selectUser">
    <fieldset>
        <legend>Login</legend>
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td> Username:</td>
                <td> <input id="username" name="username" type ="text"/></td>
            </tr>

            <tr>
                <td> Password:</td>
                <td> <input id="passwrd" name="passwrd" type ="text"/></td>
            </tr>

            <tr>
                <td> <input id="remember" name="remember" type ="checkbox"/></td>
                <td> Remember me?</td>
            </tr>

            <tr>
                <td> &nbsp;&nbsp;</td>
                <td> <input value="Login" type ="submit"/></td>
            </tr>

        </table>
    </fieldset>
</form>
<br>
<a href="/home"><button>Back</button></a>
</body>
</html>
