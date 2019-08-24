
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
<h2>Add Customer page</h2>
<br>
<form method="post" action="/addUser">
    <fieldset>
        <legend>Sign Up</legend>
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
                <td> First Name:</td>
                <td> <input id="firstName" name="firstName" type ="text"/></td>
            </tr>

            <tr>
                <td> Last Name:</td>
                <td> <input id="lastName" name="lastName" type ="text"/></td>
            </tr>

            <tr>
                <td> SSN:</td>
                <td> <input id="ssn" name="ssn" type ="text"/></td>
            </tr>

            <tr>
                <td> Email:</td>
                <td> <input id="email" name="email" type ="text"/></td>
            </tr>

            <tr>
                <td> Address:</td>
                <td> <input id="address" name="address" type ="text"/></td>
            </tr>

            <tr>
                <td> Phone Number:</td>
                <td> <input id="phone" name="phone" type ="text"/></td>
            </tr>

            <tr>
                <td> &nbsp;&nbsp;</td>
                <td> <input value="Sign Up" type ="submit"/></td>
            </tr>

        </table>
    </fieldset>

</form>
<br>
<a href="/home"><button>Back</button></a>
</body>
</html>
