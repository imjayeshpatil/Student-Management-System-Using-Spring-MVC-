<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<div align="center">
	<h1>WELCOME TO STUDENT MANAGEMENT SYSTEM USING SPRING.....</h1>
		<form action="add_admin" method="POST">
			
			<table >
				<tr>
					<td>USERNAME</td>
					<td><input type="text" name="username" ></td>

				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" name="email"></td>

				</tr>
				<tr>
					<td>PASSWORD</td>
					<td><input type="text" name="password"></td>

				</tr>
			</table>
			<input type="submit" value="Signup">
		</form>
		
	</div>

</body>
</html>