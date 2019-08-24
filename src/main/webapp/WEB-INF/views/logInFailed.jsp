<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td><h2>${message} or you can <a href="/userCreationView"> sign up if you do not have an account</a> </h2></td>
    </tr>
</table>
<form method="post" action="/selectUser">
    Username: <input id="username" name="username" type ="text"/>
    Password: <input id="passwrd" name="passwrd" type ="text"/>
    <br><br>
    <button type="submit">Submit</button>

</form>
</body>
</html>
