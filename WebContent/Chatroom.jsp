<%@page import="com.dao.model.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.model.Usermodel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat Room</title>
<style>
a.button {
 border-style: solid;
  border-width : 8px 8px 8px 8px;
  text-decoration : none;
  padding : 20px;
  border-color : #000000;
}

input[type=text] {
  width: 60%;
  height:250%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
button{
 border-style: solid;
  border-width : 8px 8px 8px 8px;
  text-decoration : none;
  padding : 20px;
  border-color : #000000
}
html, body{
    height:100%;
    width:100%;
    padding:0;
    margin:4;
}
</style>
</head>
<body>

	<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("username")==null){
	response.sendRedirect("index.jsp");
	return;
}
%>
	<h1>Private Chat Room</h1>
	<br>
	<%
		ArrayList<Message> listm = new ArrayList<Message>();

	listm = (ArrayList<Message>) request.getAttribute("result");

	for (Message m : listm) {
		if (m.getUsername().equalsIgnoreCase("TU1")) {
	%>
	<p style="color: red;">
		<b><%=m.getUsername()%></b>>>
		<%=m.getSmessage()%></p>
	<%
		}

	else {
	%>
	<p style="color: blue;">
		<b><%=m.getUsername()%></b>>>
		<%=m.getSmessage()%></p>
	<%
		}

	}
	request.removeAttribute("result");
	%>

	<form action="AddServlet">
		<input id="textbox" type="text" name="newmessage" autocomplete="off" autofocus placeholder="Message" required><br><br>
		<button class="button" id="send">SEND</button>  &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       <a href="AddServlet" class="button">REFRESH</a> &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;  &nbsp;&nbsp;       <a class="button" href="LogoutServlet">LOGOUT</a>
		&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;  &nbsp;&nbsp;       <a class="button" href="ResetAllServlet">RESET</a>
		<br><br><br>
	</form>

</body>
</html>