<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet" method="post">
<h1>WELCOME TO THE REGISTRATION PAGE</h1>
<h4>Enter your PRN no:<input type="number" name="studentPrn"></h4>
<h4>Enter your full name:<input type="text" name="studentName"></h4>
<h4>Enter your username:<input type="text" name="userName"></h4>
<h4>Enter password:<input type="text" name="userPassword"></h4>
<h4>Enter password again:<input type="text" name="confirmPassword"></h4>
<br>
<h3>REGISTER HERE:<input type="submit"></h3>

</form >
</body>
</html>