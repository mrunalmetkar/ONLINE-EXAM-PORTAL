<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="StudentOperations" method="post">
<h1>LOGGED IN SUCCESSFULLY!<br>WELCOME TO YOUR PROFILE</h1>
<br>
<br>


<h4>UPDATE PASSWORD:</h4>
<h3>Enter old password:<input type="text" name="oldpassword"></h3>
<h3>Enter new password to be updated:<input type="text" name="newpassword"></h3>
<h4>DELETE PROFILE:</h4>
<h3>Enter username which is to be deleted:<input type="text" name="uname"></h3>
<input type="submit" name="update">
<br>
<a href="TestPage0.html"><h3>GIVE TEST HERE</h3></a>
</form>
</body>
</html>