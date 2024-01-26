<%@page import="com.jspiders.smswithspringmvc.pojo.StudentPOJO"%>
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
</style>
</head>
<body>
	<%
	StudentPOJO student = (StudentPOJO) request.getAttribute("student");
	if (student != null) {
	%>
	<div align="center">
		<form action="update_student" method="post">
			<table >
				<tr>
					<td>Id</td>
					<td><input type="text" value="<%=student.getId()%>"
						readonly="true" name="id"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" value="<%=student.getName()%>"
						name="name"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" value="<%=student.getEmail()%>"
						name="email"></td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td><input type="text" value="<%=student.getMobile()%>"
						name="mobile"></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" value="<%=student.getAge()%>"
						name="age"></td>
				</tr>
			</table>
			<input type="submit" value="UPDATE">
		</form>
	</div>
	<%
	} else {
	%>
	<div align="center">
		<h1>Student not found.</h1>
	</div>
	<%
	}
	%>
</body>
</html>
