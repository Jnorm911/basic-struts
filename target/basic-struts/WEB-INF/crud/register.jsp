<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Basic Struts 2 Application - Register</title>
	</head>
	<body>
		<h1>Register</h1>
		<a href="readuser"><button class="button-report" type="button">Get User</button></a>
		<s:form action="registerUser.action" method="post">
			<s:textfield name="username" label="Username" />
			<s:textfield name="email" label="Email" />
			<s:textfield name="age" label="Age" />
			<s:textfield name="password" label="Password" />
			<s:submit/>
		</s:form>
	</body>
</html>
