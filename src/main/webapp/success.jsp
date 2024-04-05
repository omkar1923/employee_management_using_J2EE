<%@page import="jsp_employee.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mini Project</title>
<style>
/* CSS styles */
body {
  text-align: center; /* Center align content */
}

p {
  font-weight: bold; /* Make text bold */
  margin-top: 230px; /* Add space from top */
  font-size: 20px; /* Increase text size */
}
</style>
</head>
<body>

<%String message=(String)request.getAttribute("message");
if(message!=null){%>
<p><%=message %>
<%} %>
<% List<Employee> list=(List)request.getAttribute("list"); %>
<br><br>Thanks for visiting. <br>This is a mini project created using JDBC, Servlet, and JSP.</p>



   
</body>
</html>
