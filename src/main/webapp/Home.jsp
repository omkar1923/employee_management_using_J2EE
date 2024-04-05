<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* CSS styles */
.container {
  text-align: center; /* Center align content */
}

h1 {
  margin-top: 50px; /* Add some space above h1 */
}

/* Button styles */
button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 10px;
}

button:hover {
  background-color: #45a049;
}
</style>
</head>
<body>
<div class="container">
  <h1>JSP Project</h1>
  <a href="signup.jsp"><button>SignUp</button></a>
  <a href="login.jsp"><button>Login</button></a>
</div>
</body>
</html>
