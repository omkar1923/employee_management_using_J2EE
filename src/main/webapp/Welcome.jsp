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
</style>
</head>
<body>
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
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
