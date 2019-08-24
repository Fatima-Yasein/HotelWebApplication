
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>home</title>
    <link rel="stulesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<h2>Home page</h2>
<br>
<p id="start"> <marquee bgcolor="#6698FF" loop="-1" scrollamount="3" width="100%"><font color="#FFF380" size="4">
    welcome to Java Hotel  &nbsp;&nbsp;&nbsp;&nbsp;  welcome to Java Hotel  &nbsp;&nbsp;&nbsp;&nbsp;
    welcome to Java Hotel  &nbsp;&nbsp;&nbsp;&nbsp;  welcome to Java Hotel  &nbsp;&nbsp;&nbsp;&nbsp;
    welcome to Java Hotel  &nbsp;&nbsp;&nbsp;&nbsp;  welcome to Java Hotel  &nbsp;&nbsp;&nbsp;&nbsp;
    welcome to Java Hotel &nbsp;&nbsp;&nbsp;&nbsp;  welcome to Java Hotel </font> </marquee>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
</p>

Welcome ${sessionScope.username}
<br> <br>
<a href="/userCreationView">
    <button>Sign Up</button>
</a>
<a href="/userLogInView">
    <button>Log In</button>
</a>
<%--<a href="/studentDeletionView">--%>
<%--    <button>Delete Student</button>--%>
<%--</a>--%>
<%--<a href="/studentUpdateView">--%>
<%--    <button>Update Student</button>--%>
<%--</a>--%>
<%--<a href=/studentSelectionByIdView>--%>
<%--    <button>Select Student By ID</button>--%>
<%--</a>--%>
<%--<a href=/studentSelectionByNameView>--%>
<%--    <button>Select Student By Name</button>--%>
<%--</a>--%>
</body>
</html>
