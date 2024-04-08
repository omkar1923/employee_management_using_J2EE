<%@page import="jsp_employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User Details</title>
<style>
/* CSS styles */
.container {
  text-align: center; /* Center align content */
  margin-top: 50px; /
}

form {
 display: inline-block; /* Make form inline */
  text-align: left; /* Align form elements to the left */
  padding: 20px; /* Add padding */
  border: 3px solid black; /* Add border */
  border-radius: 10px; /* Add border radius */
}

input[type="text"],
input[type="number"],
button {
  padding: 10px; /* Add padding */
  margin-bottom: 10px; /* Add space between elements */
  border-radius: 5px; /* Add border radius */
  border: 1px solid #ccc; /* Add border */
}

button {
  background-color: #4CAF50; /* Green background */
  color: white; /* White text */
  border: none; /* Remove border */
  cursor: pointer; /* Cursor on hover */
}

button:hover {
  background-color: #45a049; /* Darker green background on hover */
}

h2 {
  text-align: center; /* Center align the heading */
  margin-bottom: 20px; /* Add space below the heading */
  color: #333; /* Text color */
}
</style>
</head>
<body>
<div class="container">
<% String msg=(String)request.getAttribute("message"); %>
<% if(msg!=null) { %>
  <h2>Session is used by <%=msg %></h2>
<% } %>

<form action="update" method="post">
<h2>Edit User Details</h2>
  <% Employee employee=(Employee)request.getAttribute("emp"); %>
  Id: <input type="hidden" name="id" value="<%=employee.getId() %>"><br><br>
  Name: <input type="text" name="name" value="<%=employee.getName()%>"><br><br>
  Phone: <input type="number" name="phone" value="<%=employee.getPhone() %>"><br><br>
  Email: <input type="text" name="email" value="<%=employee.getEmail() %>"><br><br>
  Password: <input type="text" name="password" value="<%=employee.getPassword() %>"><br><br>
  Designation: <input type="text" name="designation" value="<%=employee.getDesignation() %>"><br><br>
  Salary: <input type="number" name="salary" value="<%=employee.getSalary() %>"><br><br>
  <button>Update</button>
</form>
</div>
</body>
</html>
