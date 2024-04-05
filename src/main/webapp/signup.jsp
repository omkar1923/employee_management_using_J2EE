<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<style>
/* CSS styles */
.container {
  text-align: center; /* Center align content */
  margin-top: 50px; /* Add space from top */
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
</style>
</head>
<body>
<div class="container">
    <h2>Signup</h2>
    <% String message=(String)request.getAttribute("message"); 
       if(message!=null) { %>
    <h3><%=message %></h3>
    <% } %>
    <form action="details" method="post">
        Id: <input type="number" name="id"><br><br>
        Name: <input type="text" name="name"><br><br>
        Phone: <input type="number" name="phone"><br><br>
        Email: <input type="text" name="email"><br><br>
        Password: <input type="text" name="password"><br><br>
        Designation: <input type="text" name="designation"><br><br>
        Salary: <input type="number" name="salary"><br><br>
        <button>Signup</button>
    </form>
</div>
</body>
</html>
