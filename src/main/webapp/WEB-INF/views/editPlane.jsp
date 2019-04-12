<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport| Update Plane</title>
</head>
<body>
	<%
		session = request.getSession(false);
	%>
	<%
		if (session.getAttribute("Name") == null) {
	%>
	<c:redirect url="/app/login" />
	<%
		}
	%>
	<table class="table">
		<tr>
			<th class="logo"><img src="../images/plane.png" class="logoimg"></th>
			<th class="name">EDIT PLANE</th>
			<th class="name"><%=session.getAttribute("Name")%>(ADMIN)</th>
			<th class="logout">
				<form action="/AirportManagement/app/index" method="post">
					<input class="logoutbtn" type="submit" value="Logout"
						class="btnlogout">
				</form>
			</th>
		</tr>
	</table>
	<br>
	<br>
	<form action="/AirportManagement/app/updatePlane" method="post">
		<input type="text" value="${planeDetails.planeId}" name="planeId"
			hidden><br> <br> <input type="text"
			value="${planeDetails.ownerId}" name="ownerId" hidden><br>
			<table><tr><td>
		<br> Owner First Name: </td><td><input type="text"
			value="${planeDetails.ownerFirstName}" name="OwnerFirstName"><br>
			</td></tr><tr><td>
		<br> Owner Last Name: </td><td><input type="text"
			value="${planeDetails.ownerLastName}" name="ownerLastName"><br>
			</td></tr><tr><td>
		<br> Contact: </td><td><input type="number"
			value="${planeDetails.ownerContact}" name="ownerContact"><br>
			</td></tr><tr><td>
		<br> Owner Email: </td><td><input type="email"
			value="${planeDetails.ownerEmail}" name="ownerEmail"><br>
			</td></tr><tr><td>
		<br> Plane Type:</td><td> <input type="text"
			value="${planeDetails.planeType}" name="planeType"><br>
			</td></tr><tr><td>
		<br> Plane Capacity:</td><td> <input type="number"
			value="${planeDetails.planeCapacity }" name="planeCapacity"><br>
			</td></tr></table>
		<br> <input type="submit" name="submit" value="Update"><br>
		<br>
	</form>
	<br>
	<br>
	<form action="/AirportManagement/app/viewAllPlanes">
		<input type="submit" value="Cancel" name="home">
	</form>
</body>
</html>