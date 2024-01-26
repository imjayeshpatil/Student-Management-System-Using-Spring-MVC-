<%@page import="com.jspiders.smswithspringmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<jsp:include page="home.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
/* Your CSS styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    text-align: center;
    transition: background-color 0.3s ease;
}

form {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
    transition: box-shadow 0.3s ease;
}

input[type="text"], input[type="submit"] {
    padding: 10px;
    margin-bottom: 10px;
    border-radius: 4px;
    border: 1px solid #ccc;
    transition: border-color 0.3s ease;
}

input[type="submit"] {
    padding: 10px 20px;
    border: none;
    background-color: #007bff;
    color: #fff;
    cursor: pointer;
}

input[type="text"]:focus, input[type="submit"]:hover {
    border-color: #007bff;
}

table {
    border-collapse: collapse;
    width: 80%;
    margin: 20px auto;
    background-color: #fff;
    border: 1px solid #ccc;
}

th, td {
    padding: 10px;
    border: 1px solid #ccc;
}

th {
    background-color: #f2f2f2;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

tr:hover {
    background-color: #f5f5f5;
}
</style>
</head>
<body>
	<div align="center">
		<form action="edit_student" method="post">
			<table >
				<tr>
					<td>Enter Id</td>
					<td><input type="text" name="id"></td>
				</tr>
			</table>
			<input type="submit" value="EDIT">
		</form>
	</div>
	<%
	@SuppressWarnings("unchecked")
	List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("students");
	if (students != null && students.size() > 0) {
	%>
	<div align="center">
		<table >
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Age</th>
			</tr>
			<%
			for (StudentPOJO student : students) {
			%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getMobile()%></td>
				<td><%=student.getAge()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<%
	} else {
	%>
	<div align="center">
		<h1>Students not found.</h1>
	</div>
	<%
	}
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<div align="center">
		<h1><%=message%></h1>
	</div>
	<%
	}
	%>
</body>
</html>