<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"
	import="com.cognizant.Airport.Model.AdminDetails;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport| Hangars</title>
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
				VIEW ALL HANGARS
				</th>
			<th class="name"><%=session.getAttribute("Name") %>(ADMIN)
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
			<th>Hangar ID</th>
			<th>Manager ID</th>
			<th>Manager Address1</th>
			<th>Manager Address2</th>
			<th>City</th>
			<th>State</th>
			<th>Zipcode</th>
			<th></th>


		</tr>

		<c:forEach items="${hangarList}" var="pl">
			<tr>
				<td><c:out value="${pl.hangarId}">
					</c:out></td>
				<td><c:out value="${pl.managerId}">
					</c:out></td>
				<td><c:out value="${pl.managerAddress1}">
					</c:out></td>
				<td><c:out value="${pl.managerAddress2}">
					</c:out></td>
				<td><c:out value="${pl.city}">
					</c:out></td>
				<td><c:out value="${pl.state}">
					</c:out></td>
				<td><c:out value="${pl.zipCode}">
					</c:out></td>
				<td>
					<form action="/AirportManagement/app/viewhanger" method="get">
						<input type="number" value="${pl.hangarId}" name="hId" hidden>
						<input type="submit" value="Edit">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
<form action="/AirportManagement/app/addHangar" method="get">
		<input type="Submit" value="Add Hangar" name="submit">
	</form>
	<br>
	<form action="/AirportManagement/app/Home" method="get">
		<input type="Submit" value="Home" name="submit">
	</form>
</body>
</html>