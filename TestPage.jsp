<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*" %>
<html>
<head>
<title></title>
</head>
<body> 
<form action="AnswerCheckServlet" method="post">
WELCOME TO THE TEST!

<table border="1" width="303">
<tr>
<td width="100"><b>Question</b></td>
<td width="20"><b>Option1</b></td>
<td width="20"><b>Option2</b></td>
<td width="20"><b>Option3</b></td>
<td width="20"><b>Option4</b></td>
<td width="50"><b>Enter answer here</b></td>

</tr>
<%Iterator itr;%>
<% List Questions= (List)request.getAttribute("Questions");
for (itr=Questions.iterator(); itr.hasNext(); )
{
%>
<tr>
<td width="100"><%=itr.next()%></td>
<td width="20"><%=itr.next()%></td>
<td width="20"><%=itr.next()%></td>
<td width="20"><%=itr.next()%></td>
<td width="20"><%=itr.next()%></td>
<td><input type="text" name="testanswer"></td>
</tr>
<%}%>

<input type="submit" value="SUBMIT TEST">

</table>
</form>

</body>
</html>



