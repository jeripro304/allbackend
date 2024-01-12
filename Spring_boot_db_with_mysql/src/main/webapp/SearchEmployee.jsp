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
<div class="search-container" >


<form action="search">
<input type="radio" value="id" name="search">ID
<input type="radio" value="dept" name= "search">DEPT <br>
Search : <input type="text" name="input">
<input type="submit" value="Search">
</form>


</div>
</body>
</html>