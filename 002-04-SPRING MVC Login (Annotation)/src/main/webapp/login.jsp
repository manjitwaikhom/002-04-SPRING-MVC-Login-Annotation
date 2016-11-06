<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title><center>
<br><h1>User Login</h1></br>
</head>

<body>
<form:form action="verifyUser.do" method="post" commandName="user">
<table>
<tr><td>Username:</td>
<td><form:input path="username"/></td>
<td><font color="red" size=3>
<form:errors path="username"/></font></td></tr>

<tr><td>Password:</td>
<td><form:password path="password"/></td>
<td><font color="red" size=3>
<form:errors path="password"/></font></td></tr>
</table>
<br><input type="submit" value="Account Login">
</form:form>
</body>
</center>
</html>