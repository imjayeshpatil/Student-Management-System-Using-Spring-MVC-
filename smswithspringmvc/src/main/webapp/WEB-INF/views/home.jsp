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
        margin: 0;
        padding: 0;
    }

    h1 {
        margin-top: 50px;
        color: #007bff;
        font-size: 28px;
        text-transform: uppercase;
    }

    a {
        display: inline-block;
        padding: 10px 20px;
        margin: 10px;
        text-decoration: none;
        color: #fff;
        background-color: #007bff;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }

    a:hover {
        background-color: #0056b3;
    }
</style>
</head>

<body>
	<div align="center">
	<h1>WELCOME TO STUDENT MANAGEMENT SYSTEM USING SPRING.....</h1>
	<a href="add_student">Add Student</a>
	<a href="edit_student">Update Student</a>
	<a href="delete_student">Delete Student</a>
	<a href="get_student">All Students</a>
	<a href="log_out">Log Out</a>
	
	</div>
	

</body>
</html>