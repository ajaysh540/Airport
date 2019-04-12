<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport|Add Pilot</title>
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
				ADD PILOTS
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
	<form action="/AirportManagement/app/addPilotDetails" method="post">
		<table>
			<tr>
				<td>License No.</td>
				<td><input name="licNo" type="number" required></td>
			</tr>
			<tr>
				<td>Address1</td>
				<td><input type="text" name="address1" required></td>
			</tr>
			<tr>
				<td>Address2</td>
				<td><input type="text" name="address2" required></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input name="city" type="text" required></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="state" required></td>
			</tr>
			<tr>
				<td>Zipcode</td>
				<td><input type="number" name="zipcode" required></td>
			</tr>
			<tr>
				<td>SSN</td>
				<td><input type="number" name="ssn" required></td>
			</tr>
		</table>
		<input name="Submit" value="Submit" type="Submit"><br>
		<br> <input name="Reset" value="Reset" type="Reset">
	</form>
	<br><br>
	<form action="/AirportManagement/app/viewAllPilots">
		<input type="submit" value="Cancel" name="home">
	</form>
</body>
</html>