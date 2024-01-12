<%@page import="java.util.ArrayList"%>
<%@page import="com.example.db.Model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="index.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</head>
<body>
<table class="table table-striped table-hover">


 <thead> <td>Employee Id</td><td>Employee name</td><td>Employee Department</td><td>Employee salary</td> <td>Action</td></thead>
 <tbody>
 <% List<Employee> li = (List<Employee>)request.getAttribute("emplist");
for(Employee e:li){%>
<tr>
  <td><%=e.getEid()%></td>
  <td><%=e.getEname() %></td>
  <td><%=e.getDept() %></td>
  <td><%=e.getSalary()%></td> 
  <td><a href="delete?id=<%=e.getEid()%>"><button class="danger" >Delete</button> </a>  </td>
  </tr>
  <%} %>
</tbody>
  
</table>

</body>
</html>