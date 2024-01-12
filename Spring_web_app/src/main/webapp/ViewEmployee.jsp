<%@page import="com.example.db.Service.EmployeeService"%>
<%@page import="com.example.db.Model.Employee" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% EmployeeService es=new EmployeeService();
   List<Employee> emplist=es.viewemployee(); %>
   
   
<table>
<thead> <th>Eid</th><th>Name</th><th>Salary</th><th>Dept</th> </thead>
<%for (Employee e:emplist){ %>

<tr><td><%=e.getEid()%> </td> <td><%=e.getUname()%></td><td><%=e.getSalary()%></td><td><%=e.getDept()%></td></tr>
<%} %>
</table>
</body>
</html>