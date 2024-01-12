<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="index.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg}
<form action="create">

Enter name :<input type="text" name="ename" placeholder="enter your name" ><br><br>
Enter salary :<input type="text" name="salary" placeholder="enter your salary"><br><br>
Enter Dept :<select name="dept">
				<option>IT</option>
				<option>HR</option>
				<option>MR</option>
			</select> <br><br>

<input type="submit"> 
<!-- <a href="ViewEmployee.jsp"> View Employee </a> -->
</form><br><br>
</body>
</html>