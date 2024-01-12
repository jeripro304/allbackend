<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.form-container{
	display: flex;
	justify-content: center;
	
}
button{
	margin:30px;
	font-family: jokerman;
	font-size: 18px;
	border-radius:5px;
	background-color: cyan;
}
h3{
 text-align: center;
	
}
</style>
</head>
<body>
<h3>Admin Page</h3>

<div class="form-container" >
<a href="EmployeeCreate.jsp"> <button>Create Employee</button> </a>  
<a href="view"><button>View Employee</button> </a>
<a href="SearchEmployee.jsp"><button>Search Employee</button></a>
</div>

</body>
