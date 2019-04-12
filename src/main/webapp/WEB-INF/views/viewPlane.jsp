<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport</title>
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
				VIEW ALL PLANES
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
	<table>
		<tr>
			<th>Plane Id</th>
			<th>Owner ID</th>
			<th>Owner Name</th>
			<th>Owner Contact</th>
			<th>Plane Type</th>
			<th>Plane Capacity</th>
			<th></th>
		</tr>

		<c:forEach items="${planeList}" var="pl">

			<tr>
				<td><c:out value="${pl.planeId}"></c:out></td>
				<td><c:out value="${pl.ownerId}"></c:out></td>
				<td><c:out value="${pl.ownerFirstName}"></c:out> <c:out
						value="${pl.ownerLastName}"></c:out></td>
				<td><c:out value="${pl.ownerContact}"></c:out></td>
				<td><c:out value="${pl.planeType}"></c:out></td>
				<td><c:out value="${pl.planeCapacity}"></c:out></td>
				<td>
					<form action="/AirportManagement/app/ViewPlaneDetail">
						<INPUT TYPE="TEXT" hidden value="${pl.planeId } " name="pid">
						<input type="Submit" value="Edit" name="Edit">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<br>
	
	<form action="addPlane.jsp" method="get">
		<input type="Submit" value="Add Plane" name="submit">
	</form>
	<br>
	<br>

	<form action="/AirportManagement/app/Home" method="get">
		<input type="Submit" value="Home" name="submit">
	</form>
</body>
</html>