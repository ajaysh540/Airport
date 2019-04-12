<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<style>

.main {
	width: 100%;
	display: block;
	height: 100%;
	align: center;
	text-align: center;
	align-content: center;
	vertical-align: middle;
}

.input {
	border-radius: 20px;
	background-color: black;
	width: 10%;
	padding-left: 15px;
	color: white;
	border: none;
	border-width: 0px;
	border-style: solid;
	font-size: 20px;
	height: 25px;
	margin-bottom: 5px;
	font-family: Arial, sans-serif;
}

img {
	margin-top: 5%;
	vertical-align: middle;	
	width: 60%;
	height: 40%;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport</title>
</head>
<body>

	<div class="main">
		<img src="../images/plane.png" alt="logo">
		<h1>The Airport</h1>
		<br>
		<hr style="width:50%;">
		<form action="/AirportManagement/app/Login" method="post">
			<input class="input" type="number" name="userId" placeholder="USER ID" required><br>
			<input class="input" type="password" name="password" placeholder="PASSWORD" required><br><br>
			<b>
			<input type="radio" name="Profile"  value="Admin" checked>ADMIN 
			<input type="radio" name="Profile" value="Manager">MANAGER<br><br>
			</b> 
			<input class="input" style="width:7%; padding-left:0px;" type="submit" name="Submit" value="Login">
		</form><br><br>
		<form action="/AirportManagement/app/Register">
		<input class="input" style="width:10%; padding-left:0px;" type="submit" name="submit" value="Register-Manager">
		<input class="input" style="width:10%; padding-left:0px;" type="submit" name="submit" value="Register-Admin">
		</form>
		<c:if test="${not empty error }">
		<b style="color:red"><c:out value="${error }"></c:out></b>
		</c:if>
	</div>
</body>
</html>