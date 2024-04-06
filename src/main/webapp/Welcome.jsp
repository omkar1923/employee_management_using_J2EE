<%@page import="jsp_employee.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
<style>
    table {
        width: 80%;
        margin: 0 auto; /* Center the table */
        border-collapse: collapse;
    }
    th {
        font-weight: bold; /* Make table headings bold */
        background-color: #4CAF50; /* Add an attractive green background */
        color: white; /* Text color for contrast */
        padding: 10px; /* Increase padding for better spacing */
    }
    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
    h1{
    text-align: center; 
  margin-top: 50px; 
  }
   .delete-button {
        background-color: #f44336; /* Red background color */
        color: white; /* Text color for contrast */
        border: none; /* Remove border */
        padding: 8px 12px; /* Adjust padding */
        text-align: center;
        text-decoration: none;
        display: inline-block;
        cursor: pointer;
        border-radius: 4px; /* Add some rounded corners */
    }
    .delete-button:hover {
        background-color: #cc0000; /* Darker red color on hover */
    }
    
    .update-button {
        background-color: #007bff; /* Blue background color */
        color: white; /* Text color for contrast */
        border: none; /* Remove border */
        padding: 8px 12px; /* Adjust padding */
        text-align: center;
        text-decoration: none;
        display: inline-block;
        cursor: pointer;
        border-radius: 4px; /* Add some rounded corners */
    }
    .update-button:hover {
        background-color: #0056b3; /* Darker blue color on hover */
    }

    
    
</style>
</head>
<body>
<h1>Login Successful</h1>
    <%
        List<Employee> list = (List) request.getAttribute("list");
    %>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>phone</th>
            <th>email</th>
            <th>password</th>
            <th>Designation</th>
            <th>Salary</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
    
        <%
            for (Employee employee : list) {
        %>
        <tr>
            <td><%=employee.getId()%></td>
            <td><%=employee.getName()%></td>
            <td><%=employee.getPhone()%></td>
            <td><%=employee.getEmail()%></td>
            <td><%=employee.getPassword()%></td>
            <td><%=employee.getDesignation()%></td>
            <td><%=employee.getSalary()%></td>
            <td><a href="delete?id=<%=employee.getId()%>"><button class="delete-button">DELETE</button></a></td>
            <td><a href="update?id=<%=employee.getId()%>"><button class="update-button">UPDATE</button></a></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
