<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat Room Login</title>
<style type="text/css">

a.button {
    -webkit-appearance: button;
    -moz-appearance: button;
    appearance: button;

    text-decoration: none;
    color: initial;
}
html, body{
    height:100%;
    width:100%;
    padding:0;
    margin:3;
}
</style>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<form action="AuthenticateServlet">

<br><br>
<br>
<label>Username : </label><input type="text" name="username" autocomplete="off" required><br><br>

<label>Password : </label><input type="password" name="password" required><br><br>

<input type="submit">
</form>


</body>
</html>