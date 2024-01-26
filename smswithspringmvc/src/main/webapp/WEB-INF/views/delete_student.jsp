<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="home.jsp"></jsp:include>
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
	<form action="delete_student" method="POST">
			<table>
				<tr>
					<td>Id</td>
					<td><input type="text" name="id"></td>
				</tr>
				</table>
				
				<input type="submit" value="Delete">
	</form>
	
	
	</div>
	
	<div align="center">
	<% String message= (String)request.getAttribute("message");%>
	
	<%if(message!=null){
	 %>
	 <h1><%=message %></h1> 
	<% }%>
	</div>
</body>
</html>