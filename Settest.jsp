<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ExamServlet" method="post">

<h3>Exam Questions Operations </h3>
 ADD QUESTION

 
<h4>Enter Question:<input type="text" name="question" ></h4>
<h4>Enter Option1:<input type="text" name="op1" ></h4>
<h4>Enter Option2:<input type="text" name="op2" ></h4>
<h4>Enter Option3:<input type="text" name="op3" ></h4>
<h4>Enter Option4:<input type="text" name="op4" ></h4>
<h4>Enter Answer:<input type="text" name="ans" ></h4>
<input type="submit" value="submit">

<br>

DELETE QUESTION
<h4>Enter Question to be deleted:<input type="text" name="delquestion" ></h4>

<input type="submit" value="submit">
</form>
</body>
</html>