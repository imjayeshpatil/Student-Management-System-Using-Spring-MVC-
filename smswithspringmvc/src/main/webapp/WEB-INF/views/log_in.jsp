<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
	<div align="center">
	<h1>WELCOME TO STUDENT MANAGEMENT SYSTEM USING SPRING.....</h1>
		<form action="log_in" method="post">
			<input type="text" name="username" placeholder="username"> 
			<br>
			<input type="text" name="password" placeholder="password"> 
			<br>
			<input type="submit" name="log_in">
		</form>
	</div>
	<div align="center">
		<a href="add_admin">New user? Create account</a>
	</div>
	<%
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