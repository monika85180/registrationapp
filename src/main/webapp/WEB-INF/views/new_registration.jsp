<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>Registration Form</title>
	<style>
		body {
			background-color: #F2F2F2;
			font-family: Arial, sans-serif;
			margin: 0;
			padding: 0;
		}
		h1 {
			color: #333;
			text-align: center;
			margin-top: 50px;
		}
		form {
			background-color: #FFF;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
			margin: 0 auto;
			max-width: 600px;
			padding: 20px;
		}
		input[type=text], input[type=email], input[type=tel] {
			display: block;
			font-size: 16px;
			margin-bottom: 20px;
			padding: 10px;
			width: 100%;
			border: none;
			border-radius: 5px;
			box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
		}
		input[type=submit] {
			background-color: #333;
			border: none;
			border-radius: 5px;
			color: #FFF;
			cursor: pointer;
			font-size: 16px;
			padding: 10px 20px;
		}
		input[type=submit]:hover {
			background-color: #666;
		}
	</style>
</head>
<body>
	<h1>Registration Form</h1>
	<form action="newReg" method="post">
		<label for="Name"> Name:</label>
		<input type="text" id="firstName" name="name" required>

		<label for="City">City:</label>
		<input type="text" id="city" name="city" required>

		<label for="email">Email:</label>
		<input type="email" id="email" name="email" required>

		<label for="mobile">Mobile:</label>
		<input type="tel" id="mobile" name="mobile" required>

		<input type="submit" value="Submit">
	</form>
	<div>
	<%
	if(request.getAttribute("msg")!=null){
		out.println(request.getAttribute("msg"));
	}
	%>
	
	</div>
</body>
</html>
