<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport|Add Plane</title>
</head>
<body>
<%		session = request.getSession(false);		%>
		<%if(session.getAttribute("Name")==null){
			
			%>
			 <c:redirect url = "/app/login"/>
		<%}%>
<table class="table">
		<tr>
			<th class="logo"><img src="../images/plane.png" class="logoimg"></th>
			<th class="name">
				ADD PLANES
				</th>
			<th class="name"> <%=session.getAttribute("Name") %>(ADMIN)
			</th>
			<th class="logout">
				<form action="/AirportManagement/app/index" method="post">
					<input class="logoutbtn" type="submit" value="Logout" class="btnlogout">
				</form>
			</th>
		</tr>
	</table>
	<br>
	<br>
	<form action="/AirportManagement/app/AddPlaneController" method="post">
		<table>
			<tr>
				<td>Owner ID</td>
				<td><input type="number" name="ownerId" placeholder="Owner ID"
					required></td>
			</tr>
			<tr>
				<td>Owner First Name</td>
				<td><input type="text" name="ownerFirstName"
					placeholder="First Name" required></td>
			</tr>
			<tr>
				<td>Owner Last Name</td>
				<td><input type="text" name="ownerLastName"
					placeholder="Last Name" required></td>
			</tr>
			<tr>
				<td>Owner Contact</td>
				<td><input type="number" name="ownerContact"
					placeholder="Contact" required></td>
			</tr>
			<tr>
				<td>Owner Email</td>
				<td><input type="email" name="ownerEmail" placeholder="Email"
					required></td>
			</tr>
			<tr>
				<td>Plane Type</td>
				<td><input type="text" name="planeType"
					placeholder="Plane Type" required></td>
			</tr>
			<tr>
				<td>Plane Capacity</td>
				<td><input type="number" name="planeCapacity"
					placeholder="Plane Capacity" required></td>
			</tr>
		</table>
		<input type="Submit" name="submit" value="Submit"><br> <br><input
			type="reset" name="Reset" value="Reset"><br>
	</form>
	<br><br>
	<form action="/AirportManagement/app/viewAllPlanes">
		<input type="submit" value="Cancel" name="home">
	</form>
</body>
</html>