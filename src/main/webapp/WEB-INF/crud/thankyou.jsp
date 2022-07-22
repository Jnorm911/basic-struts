<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registration Successful</title>
  </head>
  <body>
    <h3>You have successfully registered</h3>

    <p>Your registration information: <s:property value="userBean" /> </p>

    <p><a href="<s:url action='index' />" >Home</a></p>
  </body>
</html>