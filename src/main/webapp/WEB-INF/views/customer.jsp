<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>

Welcome ${sessionScope.username}, ${sessionScope.id}

<br><br>
<a href="/logout">
    <button>Log Out</button>
</a>
<%--<table>--%>
<%--    <tr>--%>
<%--        <td><h2>${message}</h2></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Username : ${username}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Password : ${passwrd}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>First Name : ${firstName}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Last Name : ${lastName}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>SSN : ${ssn}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Email : ${email}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Address : ${address}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Phone Number : ${phone}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>User Role : ${userRole}</td>--%>
<%--    </tr>--%>

</table>
<br>
<a href="/home"><button>Back</button></a>
</body>
</html>
